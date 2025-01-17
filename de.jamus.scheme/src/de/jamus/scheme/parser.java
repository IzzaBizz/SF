//----------------------------------------------------
// The following code was generated by CUP v0.10j
// Tue Oct 04 16:12:10 CEST 2005
//----------------------------------------------------

package de.jamus.scheme;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * CUP v0.10j generated parser.
 * 
 * @version Tue Oct 04 16:12:10 CEST 2005
 */
public class parser extends java_cup.runtime.lr_parser {

	/** Default constructor. */
	public parser() {
		super();
	}

	/** Constructor which sets the default scanner. */
	public parser(java_cup.runtime.Scanner s) {
		super(s);
	}

	/** Production table. */
	protected static final short _production_table[][] = unpackFromStrings(new String[] { "\000\033\000\002\002\004\000\002\003\004\000\002\004"
			+ "\004\000\002\004\003\000\002\005\004\000\002\005\004"
			+ "\000\002\005\004\000\002\005\003\000\002\006\003\000"
			+ "\002\006\003\000\002\006\003\000\002\006\003\000\002"
			+ "\006\003\000\002\006\003\000\002\006\003\000\002\006"
			+ "\003\000\002\007\004\000\002\010\003\000\002\015\002"
			+ "\000\002\010\005\000\002\011\004\000\002\012\003\000"
			+ "\002\012\004\000\002\012\002\000\002\013\005\000\002"
			+ "\014\004\000\002\014\002" });

	/** Access to production table. */
	@Override
	public short[][] production_table() {
		return _production_table;
	}

	/** Parse-action table. */
	protected static final short[][] _action_table = unpackFromStrings(new String[] { "\000\046\000\030\004\010\005\015\006\004\007\014\010"
			+ "\012\011\020\014\005\015\007\016\017\017\023\021\013"
			+ "\001\002\000\036\004\ufff6\005\ufff6\006\ufff6\007\ufff6\010"
			+ "\ufff6\011\ufff6\012\ufff6\013\ufff6\014\ufff6\015\ufff6\016\ufff6"
			+ "\017\ufff6\020\ufff6\021\ufff6\001\002\000\022\004\010\005"
			+ "\015\006\004\007\014\010\012\011\020\017\023\021\013"
			+ "\001\002\000\036\004\ufff2\005\ufff2\006\ufff2\007\ufff2\010"
			+ "\ufff2\011\ufff2\012\ufff2\013\ufff2\014\ufff2\015\ufff2\016\ufff2"
			+ "\017\ufff2\020\ufff2\021\ufff2\001\002\000\022\004\010\005"
			+ "\015\006\004\007\014\010\012\011\020\017\023\021\013"
			+ "\001\002\000\036\004\ufff4\005\ufff4\006\ufff4\007\ufff4\010"
			+ "\ufff4\011\ufff4\012\ufff4\013\ufff4\014\ufff4\015\ufff4\016\ufff4"
			+ "\017\ufff4\020\ufff4\021\ufff4\001\002\000\036\004\ufffa\005"
			+ "\ufffa\006\ufffa\007\ufffa\010\ufffa\011\ufffa\012\ufffa\013\ufffa"
			+ "\014\ufffa\015\ufffa\016\ufffa\017\ufffa\020\ufffa\021\ufffa\001"
			+ "\002\000\036\004\ufff8\005\ufff8\006\ufff8\007\ufff8\010\ufff8"
			+ "\011\ufff8\012\ufff8\013\ufff8\014\ufff8\015\ufff8\016\ufff8\017"
			+ "\ufff8\020\ufff8\021\ufff8\001\002\000\032\004\010\005\015"
			+ "\006\004\007\014\010\012\011\020\014\005\015\007\016"
			+ "\017\017\023\020\uffe7\021\013\001\002\000\036\004\ufff9"
			+ "\005\ufff9\006\ufff9\007\ufff9\010\ufff9\011\ufff9\012\ufff9\013"
			+ "\ufff9\014\ufff9\015\ufff9\016\ufff9\017\ufff9\020\ufff9\021\ufff9"
			+ "\001\002\000\036\004\ufff5\005\ufff5\006\ufff5\007\ufff5\010"
			+ "\ufff5\011\ufff5\012\ufff5\013\ufff5\014\ufff5\015\ufff5\016\ufff5"
			+ "\017\ufff5\020\ufff5\021\ufff5\001\002\000\032\004\010\005"
			+ "\015\006\004\007\014\010\012\011\020\013\041\014\005"
			+ "\015\007\016\017\017\023\021\013\001\002\000\022\004"
			+ "\010\005\015\006\004\007\014\010\012\011\020\017\023"
			+ "\021\013\001\002\000\036\004\ufff7\005\ufff7\006\ufff7\007"
			+ "\ufff7\010\ufff7\011\ufff7\012\ufff7\013\ufff7\014\ufff7\015\ufff7"
			+ "\016\ufff7\017\ufff7\020\ufff7\021\ufff7\001\002\000\036\004"
			+ "\ufff3\005\ufff3\006\ufff3\007\ufff3\010\ufff3\011\ufff3\012\ufff3"
			+ "\013\ufff3\014\ufff3\015\ufff3\016\ufff3\017\ufff3\020\ufff3\021"
			+ "\ufff3\001\002\000\032\004\ufffe\005\ufffe\006\ufffe\007\ufffe"
			+ "\010\ufffe\011\ufffe\013\ufffe\014\ufffe\015\ufffe\016\ufffe\017"
			+ "\ufffe\021\ufffe\001\002\000\032\004\010\005\015\006\004"
			+ "\007\014\010\012\011\020\014\005\015\007\016\017\017"
			+ "\023\020\026\021\013\001\002\000\004\002\025\001\002"
			+ "\000\004\002\001\001\002\000\036\004\ufff0\005\ufff0\006"
			+ "\ufff0\007\ufff0\010\ufff0\011\ufff0\012\ufff0\013\ufff0\014\ufff0"
			+ "\015\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0\001\002\000"
			+ "\004\020\uffef\001\002\000\036\004\ufff1\005\ufff1\006\ufff1"
			+ "\007\ufff1\010\ufff1\011\ufff1\012\ufff1\013\ufff1\014\ufff1\015"
			+ "\ufff1\016\ufff1\017\ufff1\020\ufff1\021\ufff1\001\002\000\034"
			+ "\004\010\005\015\006\004\007\014\010\012\011\020\012"
			+ "\034\014\005\015\007\016\017\017\023\020\uffea\021\013"
			+ "\001\002\000\004\020\uffec\001\002\000\004\020\uffed\001"
			+ "\002\000\030\004\010\005\015\006\004\007\014\010\012"
			+ "\011\020\014\005\015\007\016\017\017\023\021\013\001"
			+ "\002\000\004\020\uffeb\001\002\000\004\020\037\001\002"
			+ "\000\036\004\uffee\005\uffee\006\uffee\007\uffee\010\uffee\011"
			+ "\uffee\012\uffee\013\uffee\014\uffee\015\uffee\016\uffee\017\uffee"
			+ "\020\uffee\021\uffee\001\002\000\036\004\ufffb\005\ufffb\006"
			+ "\ufffb\007\ufffb\010\ufffb\011\ufffb\012\ufffb\013\ufffb\014\ufffb"
			+ "\015\ufffb\016\ufffb\017\ufffb\020\ufffb\021\ufffb\001\002\000"
			+ "\004\002\000\001\002\000\032\004\uffff\005\uffff\006\uffff"
			+ "\007\uffff\010\uffff\011\uffff\013\uffff\014\uffff\015\uffff\016"
			+ "\uffff\017\uffff\021\uffff\001\002\000\004\020\046\001\002"
			+ "\000\032\004\010\005\015\006\004\007\014\010\012\011"
			+ "\020\014\005\015\007\016\017\017\023\020\uffe7\021\013"
			+ "\001\002\000\004\020\uffe8\001\002\000\036\004\uffe9\005"
			+ "\uffe9\006\uffe9\007\uffe9\010\uffe9\011\uffe9\012\uffe9\013\uffe9"
			+ "\014\uffe9\015\uffe9\016\uffe9\017\uffe9\020\uffe9\021\uffe9\001"
			+ "\002\000\036\004\ufffc\005\ufffc\006\ufffc\007\ufffc\010\ufffc"
			+ "\011\ufffc\012\ufffc\013\ufffc\014\ufffc\015\ufffc\016\ufffc\017"
			+ "\ufffc\020\ufffc\021\ufffc\001\002\000\036\004\ufffd\005\ufffd"
			+ "\006\ufffd\007\ufffd\010\ufffd\011\ufffd\012\ufffd\013\ufffd\014"
			+ "\ufffd\015\ufffd\016\ufffd\017\ufffd\020\ufffd\021\ufffd\001\002"
			+ "" });

	/** Access to parse-action table. */
	@Override
	public short[][] action_table() {
		return _action_table;
	}

	/** <code>reduce_goto</code> table. */
	protected static final short[][] _reduce_table = unpackFromStrings(new String[] { "\000\046\000\016\003\023\004\015\005\021\006\010\007"
			+ "\020\013\005\001\001\000\002\001\001\000\010\006\047"
			+ "\007\020\013\005\001\001\000\002\001\001\000\010\006"
			+ "\046\007\020\013\005\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\014\005\043\006\010\007"
			+ "\020\013\005\014\042\001\001\000\002\001\001\000\002"
			+ "\001\001\000\012\005\041\006\010\007\020\013\005\001"
			+ "\001\000\010\006\037\007\020\013\005\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\016\005"
			+ "\030\006\010\007\020\010\027\011\026\013\005\001\001"
			+ "\000\002\001\001\000\002\001\001\000\002\001\001\000"
			+ "\004\015\035\001\001\000\002\001\001\000\016\005\030"
			+ "\006\010\007\020\011\031\012\032\013\005\001\001\000"
			+ "\002\001\001\000\002\001\001\000\012\005\034\006\010"
			+ "\007\020\013\005\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\002\001\001\000\002\001\001\000\014\005\043\006"
			+ "\010\007\020\013\005\014\044\001\001\000\002\001\001"
			+ "\000\002\001\001\000\002\001\001\000\002\001\001" });

	/** Access to <code>reduce_goto</code> table. */
	@Override
	public short[][] reduce_table() {
		return _reduce_table;
	}

	/** Instance of action encapsulation class. */
	protected CUP$parser$actions action_obj;

	/** Action encapsulation object initializer. */
	@Override
	protected void init_actions() {
		action_obj = new CUP$parser$actions(this);
	}

	/** Invoke a user supplied parse action. */
	@Override
	public java_cup.runtime.Symbol do_action(int act_num,
			java_cup.runtime.lr_parser parser, java.util.Stack stack, int top)
			throws java.lang.Exception {
		/* call code in generated class */
		return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
	}

	/** Indicates start state. */
	@Override
	public int start_state() {
		return 0;
	}

	/** Indicates start production. */
	@Override
	public int start_production() {
		return 0;
	}

	/** <code>EOF</code> Symbol index. */
	@Override
	public int EOF_sym() {
		return 0;
	}

	/** <code>error</code> Symbol index. */
	@Override
	public int error_sym() {
		return 1;
	}

	public static void main(String args[]) throws Exception {
		// new parser(new Yylex(System.in)).parse();
		File textFile;
		textFile = new File(args[0]);
		InputStream in;
		in = new FileInputStream(textFile);
		new parser(new Yylex(new BufferedInputStream(in))).parse();
	}

	@Override
	public void syntax_error(java_cup.runtime.Symbol current) {
		report_error("Syntax error (" + current.sym + ")", current);
	}

}

/** Cup generated class to encapsulate user supplied action code. */
class CUP$parser$actions {
	private final parser parser;

	/** Constructor */
	CUP$parser$actions(parser parser) {
		this.parser = parser;
	}

	/** Method with the actual generated action code. */
	public final java_cup.runtime.Symbol CUP$parser$do_action(
			int CUP$parser$act_num,
			java_cup.runtime.lr_parser CUP$parser$parser,
			java.util.Stack CUP$parser$stack, int CUP$parser$top)
			throws java.lang.Exception {
		/* Symbol object for return from actions */
		java_cup.runtime.Symbol CUP$parser$result;

		/* select the action based on the action number */
		switch (CUP$parser$act_num) {
		/* . . . . . . . . . . . . . . . . . . . . */
		case 26: // elemlist ::=
		{
			ISchemeObject RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(10/* elemlist */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 25: // elemlist ::= datum elemlist
		{
			ISchemeObject RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(10/* elemlist */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 24: // vector ::= VBEGIN elemlist RPAREN
		{
			ISchemeObject RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(9/* vector */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 23: // inrest ::=
		{
			ISchemeObject RESULT = null;
			RESULT = new Pair();
			CUP$parser$result = new java_cup.runtime.Symbol(8/* inrest */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 22: // inrest ::= DOT datum
		{
			ISchemeObject RESULT = null;
			int daleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int daright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject da = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = da;
			CUP$parser$result = new java_cup.runtime.Symbol(8/* inrest */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 21: // inrest ::= inhalt
		{
			ISchemeObject RESULT = null;
			int inleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int inright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject in = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = in;
			CUP$parser$result = new java_cup.runtime.Symbol(8/* inrest */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 20: // inhalt ::= datum inrest
		{
			ISchemeObject RESULT = null;
			int daleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int daright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ISchemeObject da = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			int irleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int irright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject ir = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Pair(da, ir);
			CUP$parser$result = new java_cup.runtime.Symbol(7/* inhalt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 19: // rest ::= inhalt NT$0 RPAREN
		{
			ISchemeObject RESULT = null;
			// propagate RESULT from NT$0
			if (((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value != null)
				RESULT = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
						.elementAt(CUP$parser$top - 1)).value;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			ISchemeObject i = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;

			CUP$parser$result = new java_cup.runtime.Symbol(6/* rest */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 18: // NT$0 ::=
		{
			Object RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject i = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = i;
			CUP$parser$result = new java_cup.runtime.Symbol(11/* NT$0 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 17: // rest ::= RPAREN
		{
			ISchemeObject RESULT = null;
			RESULT = new Pair();
			CUP$parser$result = new java_cup.runtime.Symbol(6/* rest */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 16: // list ::= LPAREN rest
		{
			ISchemeObject RESULT = null;
			int releft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int reright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject re = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = re;
			CUP$parser$result = new java_cup.runtime.Symbol(5/* list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 15: // uqdat ::= vector
		{
			ISchemeObject RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 14: // uqdat ::= list
		{
			ISchemeObject RESULT = null;
			int lileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int liright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject li = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = li;
			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 13: // uqdat ::= SYMBOL
		{
			ISchemeObject RESULT = null;
			int syleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int syright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String sy = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
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
						RunEnv.hashtab[index] = (RunEnv.hashtab[index])
								.cons(sn1);
					}
				}
			} else {
				sn1 = new Symbol(sy);
				RunEnv.hashtab[index] = (RunEnv.nilval).cons(sn1);
			}
			RESULT = sn1;
			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 12: // uqdat ::= STRING
		{
			ISchemeObject RESULT = null;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String s = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new SchemeString(s);
			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 11: // uqdat ::= CHARACTER
		{
			ISchemeObject RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 10: // uqdat ::= DOUBLE
		{
			ISchemeObject RESULT = null;
			int dleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int dright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Double d = (Double) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new SchemeDouble(d);
			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 9: // uqdat ::= NUMBER
		{
			ISchemeObject RESULT = null;
			int nleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int nright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Integer n = (Integer) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new SchemeInteger(n);
			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 8: // uqdat ::= BOOLEAN
		{
			ISchemeObject RESULT = null;
			int boolleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int boolright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String bool = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			if (bool.equals("#t"))
				RESULT = RunEnv.bTrue;
			else
				RESULT = RunEnv.bFalse;
			CUP$parser$result = new java_cup.runtime.Symbol(4/* uqdat */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 7: // datum ::= uqdat
		{
			ISchemeObject RESULT = null;
			int udleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int udright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject ud = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = ud;
			CUP$parser$result = new java_cup.runtime.Symbol(3/* datum */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 6: // datum ::= UNQUOT uqdat
		{
			ISchemeObject RESULT = null;
			int qdleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int qdright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject qd = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Pair((ISchemeObject) RunEnv.interns("unquote"),
					new Pair(qd, RunEnv.nilval));
			CUP$parser$result = new java_cup.runtime.Symbol(3/* datum */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 5: // datum ::= QUASIQUOT uqdat
		{
			ISchemeObject RESULT = null;
			int qdleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int qdright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject qd = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Pair((ISchemeObject) RunEnv.interns("quasiquote"),
					new Pair(qd, RunEnv.nilval));
			CUP$parser$result = new java_cup.runtime.Symbol(3/* datum */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 4: // datum ::= QUOT uqdat
		{
			ISchemeObject RESULT = null;
			int qdleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int qdright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject qd = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Pair((ISchemeObject) RunEnv.interns("quote"), new Pair(
					qd, RunEnv.nilval));
			CUP$parser$result = new java_cup.runtime.Symbol(3/* datum */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 3: // datlist ::= datum
		{
			Object RESULT = null;
			int dleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int dright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject d = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RunEnv.root = d;
			System.out.print("::> ");
			(RunEnv.root).print();
			System.out.println("");
			RunEnv.root = ((RunEnv.root).expand());
			((RunEnv.root).eval()).print();
			System.out.println("");
			System.out.println("");
			CUP$parser$result = new java_cup.runtime.Symbol(2/* datlist */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 2: // datlist ::= datlist datum
		{
			Object RESULT = null;
			int dleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int dright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ISchemeObject d = (ISchemeObject) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RunEnv.root = d;
			System.out.print("::> ");
			(RunEnv.root).print();
			System.out.println("");
			RunEnv.root = ((RunEnv.root).expand());
			((RunEnv.root).eval()).print();
			System.out.println("");
			System.out.println("");
			CUP$parser$result = new java_cup.runtime.Symbol(2/* datlist */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 1: // s ::= datlist DOLLAR
		{
			Object RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(1/* s */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 0: // $START ::= s EOF
		{
			Object RESULT = null;
			int start_valleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int start_valright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Object start_val = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = start_val;
			CUP$parser$result = new java_cup.runtime.Symbol(0/* $START */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			/* ACCEPT */
			CUP$parser$parser.done_parsing();
			return CUP$parser$result;

			/* . . . . . . */
		default:
			throw new Exception(
					"Invalid action number found in internal parse table");

		}
	}
}
