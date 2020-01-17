(lambda (x y) (+ x y))

(lambda x (append x x))

((lambda x (append x x)) 'a 'b)

(define f (lambda x (append x x)))
(f '(a b c))

(define map (lambda x 
	       (if (null? (cdr x))
		   ()
		   (if (null? (cadr x))
		       ()
		       (cons 
			(eval (cons (car x) (map1 quote1 (map1 car (cdr x)))))
			(eval (cons map (cons (car x) (map1 quote1 (map1 cdr (cdr x)))))))))))

(define quote1 (lambda (x)(list 'quote x)))

(define map1 (lambda (f l) 
	       (if (null? l) 
		   () 
		   (cons (f (car l))(map1 f (cdr l))))))

(eval (cons cdr (map1 quote1 (map1 car '((( 1 2 3) (2 3 4) (3 4 5)))))))
(map1 car  '(((1 2 3)(2 3 4)(3 4 5))))
(map1 quote1 (map1 car '((( 1 2 3) (2 3 4) (3 4 5)))))
(map1 cdr  '(((1 2 3)(2 3 4)(3 4 5))))
(map1 quote1 (map1 cdr '((( 1 2 3) (2 3 4) (3 4 5)))))

(map * '())
(map cdr '(( 1 2 3) (2 3 4) (3 4 5)))
(map * '( 1 2 3) '(2 3 4) '(3 4 5))
]

::> (lambda (x y ) (+ x y ) )
+++ in case of form (lambda (...)...)
NIL
eval : exit closure-Aufruf
#<function>

::> (lambda x (append x x ) )
+++ in case of form (lambda x ...)
NIL
eval : exit closure-Aufruf
#<function>

::> ((lambda x (append x x ) ) (quote a ) (quote b ) )
+++ in case of form (lambda x ...)
NIL
eval : exit closure-Aufruf
(a b a b )

::> (define f (lambda x (append x x ) ) )
+++ in case of form (lambda x ...)
NIL
eval : exit closure-Aufruf
#<function>

::> (f (quote (a b c ) ) )
((a b c ) (a b c ) )

::> (define map (lambda x (if (null? (cdr x ) ) NIL (if (null? (cadr x ) ) NIL (
cons (eval (cons (car x ) (map1 quote1 (map1 car (cdr x ) ) ) ) ) (eval (cons ma
p (cons (car x ) (map1 quote1 (map1 cdr (cdr x ) ) ) ) ) ) ) ) ) ) )
+++ in case of form (lambda x ...)
(quote1 map1 )
eval : exit closure-Aufruf
#<function>

::> (define quote1 (lambda (x ) (list (quote quote ) x ) ) )
+++ in case of form (lambda (...)...)
NIL
eval : exit closure-Aufruf
#<function>

::> (define map1 (lambda (f l ) (if (null? l ) NIL (cons (f (car l ) ) (map1 f (
cdr l ) ) ) ) ) )
+++ in case of form (lambda (...)...)
NIL
eval : exit closure-Aufruf
#<function>

::> (eval (cons cdr (map1 quote1 (map1 car (quote (((1 2 3 ) (2 3 4 ) (3 4 5 ) )
 ) ) ) ) ) )
(2 3 )

::> (map1 car (quote (((1 2 3 ) (2 3 4 ) (3 4 5 ) ) ) ) )
((1 2 3 ) )

::> (map1 quote1 (map1 car (quote (((1 2 3 ) (2 3 4 ) (3 4 5 ) ) ) ) ) )
((quote (1 2 3 ) ) )

::> (map1 cdr (quote (((1 2 3 ) (2 3 4 ) (3 4 5 ) ) ) ) )
(((2 3 4 ) (3 4 5 ) ) )

::> (map1 quote1 (map1 cdr (quote (((1 2 3 ) (2 3 4 ) (3 4 5 ) ) ) ) ) )
((quote ((2 3 4 ) (3 4 5 ) ) ) )

::> (map * (quote NIL ) )
NIL

::> (map cdr (quote ((1 2 3 ) (2 3 4 ) (3 4 5 ) ) ) )
((2 3 ) (3 4 ) (4 5 ) )

::> (map * (quote (1 2 3 ) ) (quote (2 3 4 ) ) (quote (3 4 5 ) ) )
(6 24 60 )

fertig mit parsen!!!
Syntaxanalyse fertig!

C:\Workstation\J>