; use: (load "<abs. Path to>/JamusScheme/bin/lsp_progs/software_factories_pr6.lsp")
; e.g. (load "/home/mkain/Documents/workspace/Eclipse-JamusScheme/JamusScheme/bin/lsp_progs/software_factories_pr6.lsp")

(+ (* 2 3) 2 3 (- 6 2)) ; result: 15

(car '(a b c))           ; result: a
(car (quote (a b c)) ) ; result: a

(cdr '(a b c)) ; result: (b c )

(car '(a . (b .( c . ())))) ; result: a

(cadadr '(a (b c (d e f) g))) ; result: c

(null? '()) ; result: #t

(null? 'abc) ; result: #f

(cons 'a 'b) ; result: (a . b)  is a pair of 'a and 'b. it is not a list!

(cons 'a '()) ; result: (a ) is a pair of 'a and an empty pair object. it is a list!

(cons '(a (b c)) '(d e f)) ; result: ((a (b c ) ) d e f )

(cons (cons 'a (cons '(b c) '())) (cons 'd '(e f))) ; result: ((a (b c ) ) d e f )

((lambda (x) (+ x x)) (* 3 4)) ; result: 24

((lambda (x y) (* x y)) 3 5) ; result: 15

((lambda x x) 'a 'b 'c 'd) ; result: (a b c d )

((lambda (x) x) 'a 'b 'c 'd) ; result: a

(define fak (lambda (n) (if (= n 0) 1 (* n (fak (- n 1)))))) ; result: #<function>

(fak 10) ; result: 3628800

(define length (lambda (l) (if (null? l) 0 (+ (length (cdr l)) 1 )))) ; result: #<function>

(length '(a b c d)) ; result: 4

(length '(a (b (c (d) c) b) a)) ; result: 3 ; @students: why?

; (* a 4) ; result: ERROR! a is not defined

(define a 2) ; result: 2

(* a 4) ; result: 8

(set! a 6) ; result: 6

(* a a) ; result: 36

(define double-any (lambda (f x) (f x x))) ; result: #<function>

(double-any + 10) ; result: 20

(double-any * 10 ) ; result: 100

]