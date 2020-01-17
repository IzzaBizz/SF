

(define zins (lambda(s)(* s x)))
(define x 1)
(define neusaldo (lambda(u)(+ u (zins u))))
(neusaldo 100)
(set! x 2)
(neusaldo 100)
(set! x 3)
(neusaldo 100)


(define g (lambda (t) (+ t r)))
(define r 1)
(set! r 2)
(g 5)

(define printc (lambda(x)(if LP (print x))))
(define print (lambda(x)(display x)(newline)))

(define DATAGEN (lambda(lpp)   ; lpp = #t or #f
     (if lpp (set! LP #t)(set! LP #f))
     (print LP)
     (newline)
     (printc "***************************************************************")
     (printc "                          Datengenerator                       ")
     (printc "***************************************************************")
     (set! LP #t)
         ))
(define LP #t)
(DATAGEN #t)
(DATAGEN #f)
(DATAGEN #t)
LP
]

::> (define zins (lambda (s ) (* s x ) ) )
eval : exit closure-Aufruf
#<function>

::> (define x 1 )
1

::> (define neusaldo (lambda (u ) (+ u (zins u ) ) ) )
eval : exit closure-Aufruf
#<function>

::> (neusaldo 100 )
200

::> (set! x 2 )
2

::> (neusaldo 100 )
300

::> (set! x 3 )
3

::> (neusaldo 100 )
400

::> (define g (lambda (t ) (+ t r ) ) )
eval : exit closure-Aufruf
#<function>

::> (define r 1 )
1

::> (set! r 2 )
2

::> (g 5 )
7

::> (define printc (lambda (x ) (if LP (print x ) ) ) )
eval : exit closure-Aufruf
#<function>

::> (define print (lambda (x ) (display x ) (newline ) ) )
eval : exit closure-Aufruf
#<function>

::> (define DATAGEN (lambda (lpp ) (if lpp (set! LP #t ) (set! LP #f ) ) (print
LP ) (newline ) (printc "******************************************************
********" ) (printc "                          Datengenerator
    " ) (printc "**************************************************************
" ) (set! LP #t ) ) )
eval : exit closure-Aufruf
#<function>

::> (define LP #t )
#t

::> (DATAGEN #t )
#t

***************************************************************
                          Datengenerator
***************************************************************
#t

::> (DATAGEN #f )
#f

#t

::> (DATAGEN #t )
#t

***************************************************************
                          Datengenerator
***************************************************************
#t

::> LP
#t

fertig mit parsen!!!
Syntaxanalyse fertig!

C:\Workstation\J>
