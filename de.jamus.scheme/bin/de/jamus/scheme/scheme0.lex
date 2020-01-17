package Scheme;

import java_cup.runtime.Symbol;

%%
%implements java_cup.runtime.Scanner
%function next_token
%type java_cup.runtime.Symbol
%eofval{
  return new Symbol(sym.EOF);
%eofval}


digit=[0-9]
letter=[a-zA-Z]
speci=[!$%&*/:<=>?~_^]
sign=(\+|\-)
peculiar={sign}
initial=({letter}|{speci})
specsub=[\.+\-]
subsequent=({initial}|{digit}|{specsub})
num={sign}?{digit}+
decimal10=\.{digit}+|{digit}+\.{digit}+
real10={sign}?\.{digit}+|{sign}?{digit}+\.{digit}+
identifier=({initial}{subsequent}*)|{peculiar}
boolean=(#t|#f)
character=(#\\.)|(#\\newline)|(#\\space)
comment=; 
string=\"(\ |[a-z0-9A-Z!.?/*`'´\[\]:#><_\(\)\-=])*\"
%%

"(" { return new Symbol(sym.LPAREN ); }
")" { return new Symbol(sym.RPAREN ); }
"#("  { return new Symbol(sym.VBEGIN ); }
{identifier}  { return new Symbol(sym.SYMBOL,new String(yytext()) );  }
"'"  { return new Symbol(sym.QUOT ); }
"`"  { return new Symbol(sym.QUASIQUOT ); }
","  { return new Symbol(sym.UNQUOT ); }
{num}       { return new Symbol(sym.NUMBER, new Integer(yytext()) ); }
{real10} { return new Symbol(sym.DOUBLE, new Double(yytext()) ); }
{boolean}   { return new Symbol(sym.BOOLEAN, new String(yytext()) ); }
{string}    { return new Symbol(sym.STRING, new String(yytext()) ); }
{character} { return new Symbol(sym.CHARACTER );  }
{comment}   {  /*  	handcodiert	*/
               int ch=0;
                   do
		     ch = yy_advance();
                   while ((char)ch != '\n');
		     
             }	
"]"      { return new Symbol(sym.DOLLAR); }
[\.] { return new Symbol(sym.DOT ); }
[" "\t\r\n\f] { /* ignore white space. */ }
. { System.err.println("Illegal character: "+yytext()); }
