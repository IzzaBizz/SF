package de.jamus.scheme;

import java_cup.runtime.Symbol;

class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex(java.io.Reader reader) {
		this();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex(java.io.InputStream instream) {
		this();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(
				instream));
	}

	private Yylex() {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private final boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = { 0 };

	private void yybegin(int state) {
		yy_lexical_state = state;
	}

	private int yy_advance() throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer, yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer, yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}

	private void yy_move_end() {
		if (yy_buffer_end > yy_buffer_start
				&& '\n' == yy_buffer[yy_buffer_end - 1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start
				&& '\r' == yy_buffer[yy_buffer_end - 1])
			yy_buffer_end--;
	}

	private final boolean yy_last_was_cr = false;

	private void yy_mark_start() {
		yy_buffer_start = yy_buffer_index;
	}

	private void yy_mark_end() {
		yy_buffer_end = yy_buffer_index;
	}

	private void yy_to_mark() {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start)
				&& ('\r' == yy_buffer[yy_buffer_end - 1]
						|| '\n' == yy_buffer[yy_buffer_end - 1]
						|| 2028/* LS */== yy_buffer[yy_buffer_end - 1] || 2029/* PS */== yy_buffer[yy_buffer_end - 1]);
	}

	private java.lang.String yytext() {
		return (new java.lang.String(yy_buffer, yy_buffer_start, yy_buffer_end
				- yy_buffer_start));
	}

	private int yylength() {
		return yy_buffer_end - yy_buffer_start;
	}

	private char[] yy_double(char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2 * buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}

	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private final java.lang.String yy_error_string[] = {
			"Error: Internal error.\n", "Error: Unmatched input.\n" };

	private void yy_error(int code, boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}

	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex == -1) ? st : st.substring(0,
						commaIndex);
				st = st.substring(commaIndex + 1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j] = Integer.parseInt(workString);
					continue;
				}
				lengthString = workString.substring(colonIndex + 1);
				sequenceLength = Integer.parseInt(lengthString);
				workString = workString.substring(0, colonIndex);
				sequenceInteger = Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}

	private final int yy_acpt[] = {
	/* 0 */YY_NOT_ACCEPT,
	/* 1 */YY_NO_ANCHOR,
	/* 2 */YY_NO_ANCHOR,
	/* 3 */YY_NO_ANCHOR,
	/* 4 */YY_NO_ANCHOR,
	/* 5 */YY_NO_ANCHOR,
	/* 6 */YY_NO_ANCHOR,
	/* 7 */YY_NO_ANCHOR,
	/* 8 */YY_NO_ANCHOR,
	/* 9 */YY_NO_ANCHOR,
	/* 10 */YY_NO_ANCHOR,
	/* 11 */YY_NO_ANCHOR,
	/* 12 */YY_NO_ANCHOR,
	/* 13 */YY_NO_ANCHOR,
	/* 14 */YY_NO_ANCHOR,
	/* 15 */YY_NO_ANCHOR,
	/* 16 */YY_NO_ANCHOR,
	/* 17 */YY_NO_ANCHOR,
	/* 18 */YY_NO_ANCHOR,
	/* 19 */YY_NOT_ACCEPT,
	/* 20 */YY_NO_ANCHOR,
	/* 21 */YY_NO_ANCHOR,
	/* 22 */YY_NO_ANCHOR,
	/* 23 */YY_NOT_ACCEPT,
	/* 24 */YY_NO_ANCHOR,
	/* 25 */YY_NO_ANCHOR,
	/* 26 */YY_NOT_ACCEPT,
	/* 27 */YY_NOT_ACCEPT,
	/* 28 */YY_NOT_ACCEPT,
	/* 29 */YY_NOT_ACCEPT,
	/* 30 */YY_NOT_ACCEPT,
	/* 31 */YY_NOT_ACCEPT,
	/* 32 */YY_NOT_ACCEPT,
	/* 33 */YY_NOT_ACCEPT };
	private final int yy_cmap[] = unpackFromString(
			1,
			130,
			"18:9,30,31,18,30,31,18:18,15,4,14,3,5:3,10,1,2,4,8,12,9,7,4,6:10,4,28,4:4,1"
					+ "8,4:26,16,17,29,5,4,11,26,4,27,4,20,13,4:2,23,4:2,22,4,19,4,25,4:2,24,13,4:"
					+ "2,21,4:3,18:3,5,18,0:2")[0];

	private final int yy_rmap[] = unpackFromString(1, 34,
			"0,1:3,2,3,4,5,1:8,5,1:2,6,7,4,8,5,1,9,7,10,11,12,13,14,15,16")[0];

	private final int yy_nxt[][] = unpackFromString(
			17,
			32,
			"1,2,3,4,5:2,6,7,21:2,8,9,10,5,20,11,24:3,5:9,12,13,11:2,-1:33,14,-1:11,15,-"
					+ "1:3,19,-1:18,5:6,-1:3,5,-1:5,5:9,-1:10,6,23,-1:30,16,-1:26,18:18,22,18:4,25"
					+ ",18:6,-1:2,26:4,-1,26:2,-1,26:3,-1,26,17,26:2,-1:2,26:9,-1,26,-1:22,27,-1:3"
					+ "6,28,-1:27,29,-1:36,30,-1:27,31,-1:36,32,-1:27,33,-1:28,18,-1:30,32,-1:12");

	@Override
	public java_cup.runtime.Symbol next_token() throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol)
				yy_lookahead = YY_BOL;
			else
				yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

				return new Symbol(sym.EOF);
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			} else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				} else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:

					case -2:
						break;
					case 2: {
						return new Symbol(sym.LPAREN);
					}
					case -3:
						break;
					case 3: {
						return new Symbol(sym.RPAREN);
					}
					case -4:
						break;
					case 4: {
						System.err.println("Illegal character: " + yytext());
					}
					case -5:
						break;
					case 5: {
						return new Symbol(sym.SYMBOL, new String(yytext()));
					}
					case -6:
						break;
					case 6: {
						return new Symbol(sym.NUMBER, new Integer(yytext()));
					}
					case -7:
						break;
					case 7: {
						return new Symbol(sym.DOT);
					}
					case -8:
						break;
					case 8: {
						return new Symbol(sym.QUOT);
					}
					case -9:
						break;
					case 9: {
						return new Symbol(sym.QUASIQUOT);
					}
					case -10:
						break;
					case 10: {
						return new Symbol(sym.UNQUOT);
					}
					case -11:
						break;
					case 11: { /* ignore white space. */
					}
					case -12:
						break;
					case 12: { /* handcodiert */
						int ch = 0;
						do
							ch = yy_advance();
						while ((char) ch != '\n');
					}
					case -13:
						break;
					case 13: {
						return new Symbol(sym.DOLLAR);
					}
					case -14:
						break;
					case 14: {
						return new Symbol(sym.VBEGIN);
					}
					case -15:
						break;
					case 15: {
						return new Symbol(sym.BOOLEAN, new String(yytext()));
					}
					case -16:
						break;
					case 16: {
						return new Symbol(sym.DOUBLE, new Double(yytext()));
					}
					case -17:
						break;
					case 17: {
						return new Symbol(sym.STRING, new String(yytext()));
					}
					case -18:
						break;
					case 18: {
						return new Symbol(sym.CHARACTER);
					}
					case -19:
						break;
					case 20: {
						System.err.println("Illegal character: " + yytext());
					}
					case -20:
						break;
					case 21: {
						return new Symbol(sym.SYMBOL, new String(yytext()));
					}
					case -21:
						break;
					case 22: {
						return new Symbol(sym.CHARACTER);
					}
					case -22:
						break;
					case 24: {
						System.err.println("Illegal character: " + yytext());
					}
					case -23:
						break;
					case 25: {
						return new Symbol(sym.CHARACTER);
					}
					case -24:
						break;
					default:
						yy_error(YY_E_INTERNAL, false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
