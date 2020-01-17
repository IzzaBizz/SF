
(define x (* 3 2 7 11 )) 
(set! x 7)
(+ 1020 2000)
x 
(set! x (quote (a b c)))
x 
(define f (lambda(x)(+ x 1)))
(f 2)
x
(define y (car x))
y
(set! y (quote(a b c d e f)))
y
(null? y)
(car(cdr(cdr y)))
(if 1 (+ 2 3) (+ 3 4))
(if () (+ 2 3) (+ 3 4))
(if (quote()) (+ 2 3) (+ 3 4))
(if (null? y) 111 222)
(cons (quote (a b)) (quote(c d)))
(write "Dresden")
(write '(a b c))
(display "Dresden")
(display '(a b c))
(define append1 (lambda(u v)(if (null? u)  v (cons (car u) (append1 (cdr u) v)))))
(append1 (quote(1 2 4))(quote(3 5)))
(append (quote(1 2 4))(quote(3 5)))
(member (quote b) (quote( a b c d)))
(assoc (quote b)(quote((a . 2)(b . 5)(c . 3))))
(assoc (quote d)(quote((a . 2)(b . 5)(c . 3))))
((lambda(x)(+ 1 x))7)
(define move (lambda(uu vv)(write (cons uu vv))))
(define hanoi (lambda(nn i j k) (if (= nn 1)(move i j)(begin (hanoi (- nn 1) i k j)(move i j)(hanoi (- nn 1) k j i)))))
(hanoi 3 (quote a)(quote b)(quote c))
(hanoi 4 (quote a)(quote b)(quote c))
(list 1 2 3)
(list (quote(a b))(quote(c d)))
(list)
(define l (quote(r s t)))
(rplaca l 2)
(write l)
(rplacd l (quote(3 4)))
(write l)
(set! l (quote(a b c)))
(define mapcar (lambda (f l)
		 (if (null? l) ()
		 (cons (f (car l))(mapcar f (cdr l))))))
(eval (quote (cons 1 2)))
(mapcar eval (quote((cons(quote q)(cdr l))(car l))))

(define LP #t)
(define LOESUN #t)
(define PARLOES #t)
(define GUL 0)
(define EHZ '())
(define BASIS '())
(define TEDA '(()))
(define TED1 '())
(define ZAEL 0)
(define SZ 0)
(define datenport)
(define progvar)
(define indizvar)

(define printc (lambda(x)(if LP (print x))))

(define print (lambda(x)(display x)(newline)))

(define atom (lambda(x)(cond((symbol? x))(else (number? x)))))
(define ncons (lambda(x) (cons x '())))
(define adjoin (lambda(e l)(cond((null? l) (list e))
                ((equal? (car l) e) l)
                (else (cons (car l)(adjoin e (cdr l)))))))
(define port1)
(define port2)
(define DATAGEN (lambda(loes lpp)   ; lpp = #t or #f
     (set! PARLOES loes)
     (set! port1  (current-output-port))
     ;(set! port2 (open-output-file "TDGSScheme/output.lsp"))
     ;(set-current-output-port! port2)
     (set! GUL 0)(set! EHZ '())(set! BASIS '())
     (printc "***************************************************************")
     (printc "                          Datengenerator                       ")
     (printc "***************************************************************")
     ;(set! TEDA '())
     ;(set! TED1 '())
     (set! ZAEL 0)(set! SZ 1)
     (printc SZ)
     (set! datenport (open-input-file "TDGSScheme/daten.lsp"))
     (set! logcond1 (read datenport))
     (set! progvar (read datenport))
     (set! indizvar (read datenport))
     (letrec((hilf '())(a '())(SWITCHTED '())(var '())(var1 '())
              (var2 '())(geo '())(matrixabl '())(hilfableit '())
              (allungls '())
              (nam1 '())(nam2 '())(name '())(art '())(bedi '())
              (zzw (lambda (k)
                     (set! CCFUN k)
                     (widersp (arithsimp2 logcond1) progvar indizvar) ))
              )
           (display "logcond1:")
      )
     (printc "Ende des Testpfades") 
))
(DATAGEN #t #t)
(> 1 2)
(< 5 3)
(> 6 5 )
(< 5 5)
]
(define closure1 (closure (quote(l))(quote eval)))
(mapcar (quote eval)(quote((cons(quote q)(cdr l))(car l))))
(pair? (quote(a b)))
(pair? (quote a))
(pair? #t)
(pair? 3)
(caar (quote((a b))))
(define zins (lambda(s)(* s xy)))
(define neusaldo (lambda(x1)(+ x1 (zins x1))))
(define xy 2)
(neusaldo 100)
(define xy 1)
(neusaldo 100)
(define z (quote(1 .( 2 . 3))))
(set! z (quote(1 . 2)))
(begin (+ 2 3)(+ 3 4)(+ 4 5))
(- 18 6 3)
(expt 2 5)
(write (quote(a b )))
(write (quote a))
(write 22)
(write cons)
(cons 1 2)
(set! z 2)
(if (= 3 1) 10 11)
(if (= 2 2) 10 11)
(if (= z 2) 10 11)

(zero? 7)

(caaar '((((((a b c)))))))
(caaaar '((((((a b c)))))))
(cddddr '(a b c d e f g))
(cadddr '(a b c d e f g))

]



