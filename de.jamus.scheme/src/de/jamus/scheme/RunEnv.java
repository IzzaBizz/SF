package de.jamus.scheme;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

import de.jamus.scheme.ISchemeFunction.exprType;
import de.jamus.scheme.StElem.modeType;

import java_cup.runtime.Scanner;

/**
 * RunEnv is the default scheme run environment.
 */
public class RunEnv {

	public static Stack stack = new Stack(10000); // alt new Stack(1000)

	static Pair nilval = new Pair();
	static ISchemeObject unbound = new Symbol("unbound");

	static SchemePort current_input_port = new SchemePort("stdin");
	static SchemePort current_output_port = new SchemePort("stdout");

	static EingabeThread et = new EingabeThread();
	static InterpreterThread it = new InterpreterThread();

	static int interpreter_modus; // 0 == dialog , 1 == file

	static boolean read_status = false; // erkenne ob gerade in read
	static int number_read_call_temp; // fuer eval in pair von (read)
	static int number_read_data_temp; // fuer eval in pair von (read)

	static ISchemeObject read_object; // aktuelles SchemeObject fuer read

	public static ISchemeObject root;

	static SchemeBoolean bTrue;
	static SchemeBoolean bFalse;

	final static int tableng = 31;
	static ISchemeObject[] hashtab = new ISchemeObject[tableng];

	protected static int hash(String s, int tableng) {
		// Deprecated:
		// byte[] b = new byte[s.length()];
		// s.getBytes(0, s.length() - 1, b, 0);
		// As of JDK 1.1, the preferred way:
		byte[] b = s.getBytes();

		int h = 0;
		for (int i = 0; i < s.length(); i++)
			h += b[i];

		return (h % tableng);
	}

	/**
	 * Searches in the hash table if the given StElem is already in the list. If
	 * the element is found, the first reference is returned, else the given
	 * StElem is added and returned.
	 * 
	 * @param s
	 *            the given StElem to search for.
	 * 
	 * @return the reference to the current StElem.
	 */
	protected static StElem intern(StElem s) {
		int index = hash(s.getPname(), tableng);
		if (hashtab[index] == null) {
			// Bucket is empty: StElem is the first element in the bucket
			hashtab[index] = nilval.cons(s);
			return s;
		} else {
			// Bucket is not empty: check if the StElem is already in the bucket
			ISchemeObject z = checkbucket(s.getPname(), hashtab[index]);
			if (z.nullp()) {
				// StElem is not in the bucket: add
				hashtab[index] = hashtab[index].cons(s);
				return s;
			}
			// StElem is already in the bucket: return the reference to the
			// first one
			return (StElem) z;
		}
	}

	/**
	 * Searches in the hash table if a Symbol with the given String is already
	 * in the list. If the symbol is found, a reference to this StElem is
	 * returned, else the given StElem is added and returned.
	 * 
	 * @param sy
	 *            the given StElem to search for.
	 * 
	 * @return the reference to the current StElem.
	 */
	protected static StElem interns(String sy) {
		Symbol sn1;
		int index = hash(sy, tableng);
		if (hashtab[index] == null) {
			// Bucket is empty: Add the new symbol
			sn1 = new Symbol(sy);
			hashtab[index] = nilval.cons(sn1);
		} else {
			// Bucket is not empty: check if the symbol is already in the bucket
			ISchemeObject x = checkbucket(sy, hashtab[index]);
			if (x != null && x instanceof Symbol) {
				// Symbol is already in the bucket: return the reference to the
				// symbol
				sn1 = (Symbol) x;
			} else {
				// Symbol is not in the bucket: add it to the bucket
				sn1 = new Symbol(sy);
				hashtab[index] = (hashtab[index]).cons(sn1);
			}
		}
		return sn1;
	}

	/**
	 * Checks if the given bucket (list) contains the given Pname.
	 * 
	 * @param pname
	 *            the given Pname
	 * @param bucket
	 *            the given bucket (hashtab[index])
	 * 
	 * @return the bucket if it is found else an empty bucket.
	 */
	static ISchemeObject checkbucket(String pname, ISchemeObject bucket) {
		if (bucket.nullp())
			return bucket;

		if (((StElem) ((Pair) bucket).car()).getPname().equals(pname))
			return ((Pair) bucket).car();
		else
			return checkbucket(pname, ((Pair) bucket).cdr());
	}

	public static boolean init() {
		// Symbols
		newSymEntry(new Symbol("nil"));
		// Boolean
		newSymEntry(new SchemeBoolean("#t"));
		newSymEntry(new SchemeBoolean("#f"));
		// Pair functions
		try {
			newSymEntry(new SchemeFunction("car", Class.forName("de.jamus.scheme.Pair"),
					exprType.EXPR));

			newSymEntry(new SchemeFunction("cdr", Class.forName("de.jamus.scheme.Pair"),
					exprType.EXPR));

			newSymEntry(new SchemeFunction("caar",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR));

			newSymEntry(new SchemeFunction("cddr",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR));

			newSymEntry(new SchemeFunction("cadr",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR));

			newSymEntry(new SchemeFunction("cdar",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR));

			newSymEntry(new SchemeFunction("reverse",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR));

			newSymEntry(new SchemeFunction("append",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2r,
					Class.forName("de.jamus.scheme.Pair")));

			newSymEntry(new SchemeFunction("member",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("assoc",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("list",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("quotient",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("remainder",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("min", Class.forName("de.jamus.scheme.Pair"),
					exprType.LIST));

			newSymEntry(new SchemeFunction("max", Class.forName("de.jamus.scheme.Pair"),
					exprType.LIST));

			newSymEntry(new SchemeFunction("length",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("abs", Class.forName("de.jamus.scheme.Pair"),
					exprType.LIST));

			newSymEntry(new SchemeFunction("exact->inexact", "exactinexact",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("inexact->exact", "inexactexact",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("rplaca",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2r,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("rplacd",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2r,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("set-car!", "setcar",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2r,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("set-cdr!", "setcdr",
					Class.forName("de.jamus.scheme.Pair"), exprType.EXPR2r,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("string<=?", "stringle",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("+", "iplus",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("-", "iminus",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("*", "itimes",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("/", "idivision",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("expt", "iexpt",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("=", "eq",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("<", "lt",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction(">", "gt",
					Class.forName("de.jamus.scheme.Pair"), exprType.LIST));

			newSymEntry(new SchemeFunction("eval",
					Class.forName("de.jamus.scheme.ISchemeObject"), exprType.EXPR));

			newSymEntry(new SchemeFunction("cons",
					Class.forName("de.jamus.scheme.ISchemeObject"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("eq?", "eqp",
					Class.forName("de.jamus.scheme.ISchemeObject"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("equal?", "equalp",
					Class.forName("de.jamus.scheme.ISchemeObject"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("null?", "nullpp",
					Class.forName("de.jamus.scheme.ISchemePair"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("pair?", "pairp",
					Class.forName("de.jamus.scheme.ISchemePair"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("list?", "listp",
					Class.forName("de.jamus.scheme.ISchemePair"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("number?", "numberp",
					Class.forName("de.jamus.scheme.ISchemeNumber"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("positive?", "positivep",
					Class.forName("de.jamus.scheme.ISchemeNumber"), exprType.EXPR));

			newSymEntry(new SchemeFunction("zero?", "zerop",
					Class.forName("de.jamus.scheme.ISchemeNumber"), exprType.EXPR));

			newSymEntry(new SchemeFunction("negative?", "negativep",
					Class.forName("de.jamus.scheme.ISchemeNumber"), exprType.EXPR));

			newSymEntry(new SchemeFunction("number->string", "numberstring",
					Class.forName("de.jamus.scheme.ISchemeNumber"), exprType.EXPR));

			newSymEntry(new SchemeFunction("integer?", "integerp",
					Class.forName("de.jamus.scheme.ISchemeInteger"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("real?", "realp",
					Class.forName("de.jamus.scheme.ISchemeReal"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("not",
					Class.forName("de.jamus.scheme.ISchemeBoolean"), exprType.EXPR));

			newSymEntry(new SchemeFunction("symbol?", "symbolp",
					Class.forName("de.jamus.scheme.ISchemeSymbol"), exprType.EXPRp));

			newSymEntry(new SchemeFunction("symbol->string", "symbolstring",
					Class.forName("de.jamus.scheme.ISchemeSymbol"), exprType.EXPR));

			newSymEntry(new SchemeFunction("string->symbol", "stringsymbol",
					Class.forName("de.jamus.scheme.ISchemeString"), exprType.EXPR));

			newSymEntry(new SchemeFunction("string-append", "stringappend",
					Class.forName("de.jamus.scheme.SchemeString"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.SchemeString")));

			newSymEntry(new SchemeFunction("write",
					Class.forName("de.jamus.scheme.RunEnv"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("display",
					Class.forName("de.jamus.scheme.RunEnv"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("newline",
					Class.forName("de.jamus.scheme.RunEnv"), exprType.LIST));

			newSymEntry(new SchemeFunction("load",
					Class.forName("de.jamus.scheme.RunEnv"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("current-input-port",
					"current_input_port", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.LIST));

			newSymEntry(new SchemeFunction("current-output-port",
					"current_output_port", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.LIST));

			newSymEntry(new SchemeFunction("set-current-input-port!",
					"set_current_input_port", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.EXPR2, Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("set-current-output-port!",
					"set_current_output_port", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.EXPR2, Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("open-input-file",
					"open_input_file", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.EXPR2, Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("open-output-file",
					"open_output_file", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.EXPR2, Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("close-input-file",
					"close_input_port", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.EXPR2, Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("close-output-file",
					"close_output_port", Class.forName("de.jamus.scheme.RunEnv"),
					exprType.EXPR2, Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("read",
					Class.forName("de.jamus.scheme.RunEnv"), exprType.EXPR2,
					Class.forName("de.jamus.scheme.ISchemeObject")));

			newSymEntry(new SchemeFunction("exit",
					Class.forName("de.jamus.scheme.RunEnv"), exprType.LIST));

			return true;

		} catch (ClassNotFoundException e) {
			System.err.println("Error(RunEnv.init())::" + e);
		}
		return false;
	}

	/*
	 * private static Class<?> getExternClass(SchemeFunction x, Class<?> aClass)
	 * throws ClassNotFoundException, NoSuchMethodException, SecurityException {
	 * Class<?> bClass = Class.forName(x.getClassn());
	 * 
	 * if (x.getPname().equals("move")) { System.out.println("move gefunden!");
	 * aClass = Class.forName("Scheme.Pair"); Class<?>[] paramsm = { aClass,
	 * aClass }; x.setValue(bClass.getDeclaredMethod(x.getPname(), paramsm));
	 * x.setParams(paramsm); } else {
	 * x.setValue(bClass.getDeclaredMethod(x.getPname())); }
	 * 
	 * return bClass; }
	 */

	private static void newSymbolEntry(Symbol x) {
		x.setValue(x);
		x = (Symbol) intern(x);

		// System.out.println("   Symbol: " + x.getPname());
	}

	private static void newSchemeBooleanEntry(SchemeBoolean x) {
		// Set value of SchemeBoolean to itself
		x.setValue(x);
		x = (SchemeBoolean) intern(x);
		// Set RunEnv boolean values: true and false
		if (x.getPname().equals("#t"))
			bTrue = x;
		else
			bFalse = x;

		// System.out.println("   Boolean: " + x.getPname());
	}

	private static void newSchemeFunctionEntry(SchemeFunction x) {
		// Create symbol for function
		Symbol symbolForFunc = new Symbol(x.getPname());

		symbolForFunc.setValue(x);
		symbolForFunc.setModeToAssigned();

		// add the symbol to the hash table
		symbolForFunc = (Symbol) intern(symbolForFunc);

		// System.out.println("   Method: " + x.getPname());
	}

	private static void newSymEntry(StElem x) {
		x.setModeToImplemented();

		if (x instanceof Symbol)
			newSymbolEntry((Symbol) x);

		else if (x instanceof SchemeBoolean)
			newSchemeBooleanEntry((SchemeBoolean) x);

		else if (x instanceof SchemeFunction)
			newSchemeFunctionEntry((SchemeFunction) x);

		else
			System.err.println("Error(RunEnv.newSymEntry)::"
					+ "new symbol entry with unknown instance: " + x);
	}

	static void bind(Pair vars, Pair args, IStack bstack) {
		while (!(vars.nullp())) {
			if (((Symbol) vars.car()).isModeSetTo(modeType.UNASSIGNED)) {
				bstack.push(RunEnv.unbound.cons(vars.car()));
				((Symbol) vars.car()).setModeToAssigned();
			} else {
				bstack.push(((ISchemeObject) ((Symbol) vars.car()).getValue())
						.cons(vars.car()));
			}
			((Symbol) vars.car()).setValue(args.car());
			// System.out.println("bind:");
			vars = (Pair) vars.cdr();
			args = (Pair) args.cdr();
		}
		// System.out.println("bind: exit");
	}

	static void bind1(Symbol var, Pair args, IStack bstack) {
		// System.out.println("bind1: entry");
		if (var.isModeSetTo(modeType.UNASSIGNED)) {
			bstack.push(RunEnv.unbound.cons(var));
			var.setModeToAssigned();
		} else {
			bstack.push(((ISchemeObject) var.getValue()).cons(var));
		}
		var.setValue(args);
		// System.out.println("bind1: exit");
	}

	static void unbind(Pair vars, IStack bstack) {
		// System.out.println("unbind: ");
		// vars.print() ;
		// System.out.println();
		ISchemeObject b;
		while (!(vars.nullp())) {
			b = (ISchemeObject) bstack.top();
			bstack.pop();
			// System.out.println("after pop:");
			// b.print();
			// System.out.println();
			// if (((Pair)b).cdr().equals(nilval))
			if ((((Pair) b).cdr() == RunEnv.unbound)
					&& (((Symbol) ((Pair) b).car()).getToplevelValue() == null)) // Toplevel-Wert?

				((Symbol) ((Pair) b).car()).setModeToUnassigned();

			else
				((Symbol) ((Pair) b).car()).setValue(((Pair) b).cdr());
			vars = (Pair) vars.cdr();
		}
	}

	static void unbind1(Symbol var, IStack bstack) {
		// System.out.println("unbind1: entry");
		// vars.print() ;
		// System.out.println();
		ISchemeObject b;
		b = (ISchemeObject) bstack.top();
		bstack.pop();
		// System.out.println("after pop:");
		// b.print();
		// System.out.println();
		// if (((Pair)b).cdr().equals(nilval))
		if ((((Pair) b).cdr() == RunEnv.unbound)
				&& (((Symbol) ((Pair) b).car()).getToplevelValue() == null)) // Toplevel-Wert?
			((Symbol) ((Pair) b).car()).setModeToUnassigned();
		else
			((Symbol) ((Pair) b).car()).setValue(((Pair) b).cdr());
	}

	static void bind(Pair vars, Pair args) {
		bind(vars, args, stack);
	}

	static void bind1(Symbol var, Pair args) {
		bind1(var, args, stack);
	}

	static void unbind(Pair vars) {
		unbind(vars, stack);
	}

	static void unbind1(Symbol var) {
		unbind1(var, stack);
	}

	// Datei laden
	public static ISchemeObject load(ISchemeObject param) {
		if (param instanceof Pair) {
			System.err.println("Error(RunEnv.load)::Cannot load file: "
					+ "Please use String syntax, e.g. (load \"file.lsp\")!");
			return RunEnv.nilval;
		}

		try {
			FileReader in;
			SchemeString so = (SchemeString) param;
			String file = so.value;
			System.out.println("> load: '" + file + "'");
			in = new FileReader(file);
			Scanner sc = new Yylex(new BufferedReader(in));
			// Konstruktor erst ab JLex Version 1.2.6 verfuegbar
			parser p = new parser(sc);
			p.parse();
			in.close();
		} catch (Exception e) {
			System.err.println("Error(RunEnv.load)::Cannot load file: "
					+ e.getMessage());
		}
		return RunEnv.nilval;
	}

	// Eingabedatei oeffnen
	public static ISchemeObject open_input_file(ISchemeObject param) {
		try {
			FileReader open_file_reader;
			BufferedReader open_buffer_reader;
			SchemeString so = (SchemeString) param;
			String file = (so.value);

			String textFile = file.substring(1, file.length() - 1);
			System.out.println(textFile);
			open_file_reader = new FileReader(textFile);
			open_buffer_reader = new BufferedReader(open_file_reader);
			SchemePort port = new SchemePort(open_file_reader,
					open_buffer_reader, textFile);

			return port;

		} catch (Exception e) {
			System.out.println("Fehler Datei oeffen" + e);

			return RunEnv.nilval;
		}

	}

	// Ausgabedatei oeffnen
	public static ISchemeObject open_output_file(ISchemeObject param) {
		try {
			FileWriter open_file_writer;
			BufferedWriter open_buffer_writer;
			SchemeString so = (SchemeString) param;
			String file = (so.value);

			String textFile = file.substring(1, file.length() - 1);

			open_file_writer = new FileWriter(textFile);
			open_buffer_writer = new BufferedWriter(open_file_writer);
			SchemePort port = new SchemePort(open_file_writer,
					open_buffer_writer, textFile);

			return port;

		} catch (Exception e) {
			System.out.println("Fehler Datei erstellen" + e);

			return RunEnv.nilval;
		}

	}

	// Dateiport schliessen (Eingabe)
	public static ISchemeObject close_input_port(ISchemeObject in) {
		SchemePort po = (SchemePort) in;

		if (po.port_description != "stdin") {
			FileReader open_file_reader = (po.open_file_reader);
			BufferedReader open_buffer_reader = (po.open_buffer_reader);

			try {
				open_buffer_reader.close();

				open_file_reader.close();
			} catch (Exception e) {
				System.out.println("Fehler Datei schliessen" + e);
			}
			return RunEnv.nilval;
		} else {
			System.out.println("Standartport kann nicht geschlossen werden");

			return RunEnv.nilval;
		}
	}

	// Dateiport schliessen (Ausgabe)
	public static ISchemeObject close_output_port(ISchemeObject out) {
		SchemePort po = (SchemePort) out;

		if (po.port_description != "stdout") {
			FileWriter open_file_writer = (po.open_file_writer);
			BufferedWriter open_buffer_writer = (po.open_buffer_writer);

			try {
				open_buffer_writer.close();

				open_file_writer.close();

			} catch (Exception e) {
				System.out.println("Fehler Datei schliessen" + e);
			}

			return RunEnv.nilval;
		} else {
			System.out.println("Standartport kann nicht geschlossen werden");

			return RunEnv.nilval;
		}
	}

	public static ISchemeObject read(ISchemeObject in) {

		SchemePort po = (SchemePort) in;
		read_status = true;

		if (po.port_description != "stdin") {
			try {
				// FileReader open_file_reader = (po.open_file_reader);
				BufferedReader open_buffer_reader = (po.open_buffer_reader);
				number_read_call_temp = po.number_read_call;
				number_read_data_temp = po.number_read_data;

				Scanner sc = new Yylex(open_buffer_reader);
				// Konstruktor erst ab JLex Version 1.2.6 verfuegbar
				parser p = new parser(sc);
				p.parse();

			} catch (Exception e) {
				System.out.println("Fehler Datei oeffen/laden");
			}
		}
		read_status = false;
		number_read_call_temp = number_read_call_temp + 1;
		number_read_data_temp = 0;
		po.number_read_call = number_read_call_temp; // auf SchemePort speichern
		po.number_read_data = number_read_data_temp; // auf SchemePort speichern

		po.resetBufferedReader();
		return RunEnv.read_object;
	}

	/*
	 * public static SchemeObject read(SchemeObject in) { SchemePort po =
	 * (SchemePort)in;
	 * 
	 * if (po.port_description != "stdin") { FileReader open_file_reader =
	 * (po.open_file_reader); BufferedReader open_buffer_reader =
	 * (po.open_buffer_reader); int ebene = 0; char ebene_plus = '('; char
	 * ebene_minus = ')'; String eingabe_zeile; String eingabe_gesamt= ""; int
	 * start; int index;
	 * 
	 * try{ do { eingabe_zeile = open_buffer_reader.readLine(); start = 0;
	 * System.out.println(eingabe_zeile); // nach "(" suchen , wenn gefunden
	 * ebene++ while ( (index = eingabe_zeile.indexOf(ebene_plus, start)) >= 0)
	 * { ebene++; start = index+1; }
	 * 
	 * start = 0; // nach ")" suchen , wenn gefunden ebene-- while ( (index =
	 * eingabe_zeile.indexOf(ebene_minus, start)) >= 0) { ebene--; start =
	 * index+1; }
	 * 
	 * eingabe_gesamt = eingabe_gesamt.concat(eingabe_zeile); }while(ebene > 0);
	 * // solange nicht alle Klammern wieder geschlossen weiterlesen
	 * 
	 * SchemeString s = new SchemeString(eingabe_gesamt);
	 * 
	 * return s;
	 * 
	 * } catch (Exception e){ System.out.println("Fehler Datei oeffen/laden");
	 * return RunEnv.nilval; } } else {
	 * System.out.println("stdin fuer read noch nicht implemtiert"); return
	 * RunEnv.nilval; } }
	 */

	public static ISchemeObject write(ISchemeObject param) {

		if (current_output_port.port_description == "stdout") {
			param.print();
		} else {
			// FileWriter open_file_writer =
			// (current_output_port.open_file_writer);
			BufferedWriter open_buffer_writer = (current_output_port.open_buffer_writer);

			param.printp(open_buffer_writer);
		}

		return RunEnv.nilval;
	}

	public static ISchemeObject display(ISchemeObject param) {

		if (current_output_port.port_description == "stdout") {
			if (param instanceof SchemeString) {
				SchemeString textstring = (SchemeString) param;
				String text = textstring.value;
				String textAusgabe;
				if (text.charAt(0) == 34) {
					textAusgabe = text.substring(1, text.length() - 1);
					SchemeString paramAusgabe = new SchemeString(textAusgabe);
					paramAusgabe.print();
				} else
					param.print();
			} else
				param.print();
		} else {
			// FileWriter open_file_writer =
			// (current_output_port.open_file_writer);
			BufferedWriter open_buffer_writer = (current_output_port.open_buffer_writer);
			if (param instanceof SchemeString) {
				SchemeString textstring = (SchemeString) param;
				String text = textstring.value;
				String textAusgabe;
				if (text.charAt(0) == 34) {
					textAusgabe = text.substring(1, text.length() - 1);
					SchemeString paramAusgabe = new SchemeString(textAusgabe);
					paramAusgabe.printp(open_buffer_writer);
				} else
					param.printp(open_buffer_writer);
			} else
				param.printp(open_buffer_writer);
		}

		return RunEnv.nilval;
	}

	public static ISchemeObject newline() {
		if (current_output_port.port_description == "stdout") {
			RunEnv.nilval.newline();
		} else {
			try {
				// FileWriter open_file_writer =
				// (current_output_port.open_file_writer);
				BufferedWriter open_buffer_writer = (current_output_port.open_buffer_writer);
				open_buffer_writer.newLine();

			} catch (Exception e) {
				System.out.println("Fehler Datei schreiben");
			}
		}
		return RunEnv.nilval;
	}

	public static ISchemeObject current_input_port() {

		return current_input_port;
	}

	public static ISchemeObject current_output_port() {
		return current_output_port;
	}

	public static ISchemeObject set_current_input_port(
			ISchemeObject new_current_input_port) {
		current_input_port = (SchemePort) new_current_input_port;

		return RunEnv.nilval;
	}

	public static ISchemeObject set_current_output_port(
			ISchemeObject new_current_output_port) {
		current_output_port = (SchemePort) new_current_output_port;

		return RunEnv.nilval;
	}

	/*
	 * alter Interpreter public static void interpreter(File textFile) throws
	 * Exception{ // parser p = new parser(new Yylex(System.in)); //File
	 * textFile; //textFile=new File("Scheme/input3.lsp"); InputStream in; in=
	 * new FileInputStream(textFile); Scanner sc = new Yylex(new
	 * BufferedInputStream((InputStream)in)); parser p = new parser(sc); //while
	 * (true){ //System.out.println("my_interpreter>"); p.parse();
	 * System.out.println("fertig mit parsen!!!"); //p = new parser(sc);
	 * //(RunEnv.root).eval(); //((RunEnv.root).eval()).print(); //} }
	 */

	public static void exit() {
		if (interpreter_modus == 0)
			et.run_interpreter = false;
		else
			System.exit(0);
	}

	static class EingabeThread extends Thread {
		private PipedWriter out;
		private String s = "";
		private boolean run_interpreter = true;

		private final BufferedReader sys_in = new BufferedReader(
				new InputStreamReader(System.in));

		EingabeThread() {
			out = new PipedWriter();
		}

		PipedWriter getEingabeThread() {
			return out;
		}

		boolean getRunValue() {
			return run_interpreter;
		}

		@Override
		public void run() {
			PrintWriter pw = new PrintWriter(out);

			System.out.print("scheme>"); // fuer erste Ausgabe
			while (run_interpreter) {
				try {
					s = sys_in.readLine();

					// nur wenn Eingabe vorhanden
					if ((s.length() > 0)) {
						s = s + "]";
						pw.println(s);

						out = new PipedWriter();

						Thread.sleep(100); // sicherheishalber warten;

						pw.close();

						pw = new PrintWriter(out);
					}

				} catch (IOException e) {
				} catch (InterruptedException e) {
				}
			}
		}
	}

	static class InterpreterThread extends Thread {
		private PipedReader in;
		private boolean run_interpreter = true;;

		InterpreterThread() {
		}

		@Override
		public void run() {

			BufferedReader br;

			while (true)
				try {
					run_interpreter = et.getRunValue();

					if (run_interpreter) {

						in = new PipedReader(et.getEingabeThread());
						br = new BufferedReader(in);

						Scanner sc = new Yylex(new BufferedReader(br));
						parser p = new parser(sc);
						p.parse();

						System.out.print("scheme>"); // damit immer nach ausgabe
														// von werten
						// System.out.println("fertig mit parsen!!!");
					} else {
						break;
					}

				} catch (Exception e) {
				}

		}
	}

	public static void interpreter_dialog() throws Exception {

		interpreter_modus = 0;

		et.start();
		it.start();
	}

	public static void interpreter_file(File textFile) throws Exception {

		InputStream in;

		interpreter_modus = 1;

		in = new FileInputStream(textFile);

		Scanner sc = new Yylex(new BufferedInputStream(in));

		parser p = new parser(sc);
		p.parse();

		// System.out.println("fertig mit parsen!!!");
	}

}
