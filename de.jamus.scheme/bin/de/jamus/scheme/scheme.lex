package Scheme;

import java_cup.runtime.Symbol;

%%
%cup

digit=[0-9]
letter=[a-zA-Z]
speci=[!$%&*/:<=>~_^]
sign=(\+|\-)
peculiar={sign}
initial=({letter}|{speci})
specsub=[\.+\-]
subsequent=({initial}|{digit}|{specsub})
num={sign}?{digit}+
identifier=({initial}{subsequent}*)|{peculiar}
boolean=(#t|#f)
character=(#\\.)|(#\\newline)|(#\\space)
stringbeg=[\"]
comment=[;]

%%

{comment} {/* handcodiert    */
          }
"(" { return new Symbol(sym.LPAREN ); }
")" { return new Symbol(sym.RPAREN ); }
"." { return new Symbol(sym.DOT ); }
"#(" { return new Symbol(sym.VBEGIN ); }
{identifier} { return 0;
             }
{num}        { return 0;
             }
{boolean}   { return 0;}
{character} { return 0; }
{stringbeg} { return 0;
            }
"]"      { return new Symbol(sym.DOLLAR); }
