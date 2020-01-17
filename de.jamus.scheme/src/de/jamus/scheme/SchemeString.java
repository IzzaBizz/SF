package de.jamus.scheme;

import java.io.BufferedWriter;

public class SchemeString extends StElem implements ISchemeString {
	String value;

	public SchemeString(String x) {
		super();
		value = x.substring(1, x.length() - 1); // entfernen der "
	}

	/*
	 * public SchemeObject write(){ System.out.print(value);
	 * System.out.println(""); return RunEnv.nilval; }
	 */

	@Override
	public String sprint() {
		return value;
	}

	@Override
	public void print() {
		System.out.print(sprint());
	}

	@Override
	public ISchemeObject printp(BufferedWriter open_buffer_writer) {
		try {
			open_buffer_writer.write(sprint());
		} catch (Exception e) {
			System.err.println("Error(SchemeObject.printp)::" + e.getMessage());
		}
		return RunEnv.nilval;
	}

	@Override
	public SchemeBoolean eqp(ISchemeObject o) {
		if (this.value.equals(((SchemeString) o).value))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	public SchemeBoolean stringle(SchemeString s) {
		if (this.value.equals(s.value))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	public SchemeString stringappend(SchemeString s) {
		return new SchemeString("\"" + s.value.concat(this.value) + "\"");
	}

	@Override
	public Symbol stringsymbol() {
		String sy = this.value;
		int index = RunEnv.hash(sy, 31);
		Symbol sn1;
		if (RunEnv.hashtab[index] != null) {
			ISchemeObject x = RunEnv.checkbucket(sy, RunEnv.hashtab[index]);
			if (x == null) {
				sn1 = new Symbol(sy);
				RunEnv.hashtab[index] = (RunEnv.hashtab[index]).cons(sn1);
			} else {
				if (x instanceof Symbol) {
					sn1 = (Symbol) x;
				} else {
					sn1 = new Symbol(sy);
					RunEnv.hashtab[index] = (RunEnv.hashtab[index]).cons(sn1);
				}
			}
		} else {
			sn1 = new Symbol(sy);
			RunEnv.hashtab[index] = (RunEnv.nilval).cons(sn1);
		}
		return sn1;

	}

	@Override
	public SchemeBoolean equalp(ISchemeObject o) {
		if (this.value.equals(((SchemeString) o).value))
			return RunEnv.bTrue;
		else
			return RunEnv.bFalse;
	}

	@Override
	public ISchemeObject eval() {
		return this;
	}

}
