; #t      ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          #t


; +     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (+ 1)
          (+ 1 2 3 4 5 6 7 8 9 10)

; -     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (- 1)
          (- 10 2 3 4)

; /     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (/ 4)
          (/ 10 2)
          (/ 10 3)

; =     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (= 1 1)

; abs     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (abs -7)
          (abs 0)
          (abs 4)

; and     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (and)
          (and 3)
          (and (= 2 2)(> 2 1))
          (and (= 2 2)(< 2 1))
          (and 'a 'b)
          (and 1 2 'c '(f g))

; assoc     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (assoc 'c '((a . 1)(b . 2)(c . 3)(d . 4)(e . 5)))
          (assoc '(c) '(((a)1)((b)2)((c)3)((d)4)((e)5)))

; begin     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (begin (+ 2 3)(+ 3 4)(+ 4 5))
          (define x 0)
          (begin (set! x 5)(+ x 1))

; car     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (car '(a b))
          (car '((a b)))
          (car '((a)))

; cdr     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (cdr '(a b))
          (cdr '((a b)(c d)))

; cond     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

         (define lc (cdr '((a b c))))
         (cond ((null? lc) 1)
               (else 2))
         (cond((or(null? (cdr '(-255)))(null? '(-154 0))) '())
              (else 222))

; define   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (define x 1)
          (define zins (lambda(s)(* s x)))
          (define neusaldo (lambda(x)(+ x (zins x))))
          (neusaldo 100)

; display   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (display "Dresden")
          (display '(a b c))

; do   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (do((y '(1 2 3) (cdr y))
              (s 0 (+ s (car y))))
             ((null? y) s))        ; result: 6

; eq?    ;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (eq? 'a 'a)                   ; result: #t
          (eq? '(a) '(a))               ; result: #f
          (eq? 0 0)                     ; result: #t
          (eq? 3 0)                     ; result: #f
          (eq? "a" (symbol->string 'a)) ; result: #t
          (eq? 3 (+ 1 2))               ; result: #t

; equal?    ;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (equal? 'a 'a)             ; result: #t
          (equal? '(a) '(a))         ; result: #t
          (equal? '(a) '(b))         ; result: #f
          (equal? '(a . b) '(a . b)) ; result: #t


; if       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (if 1 (+ 2 3) (+ 3 4))         ; result: 5 (true-case)
          (if () (+ 2 3) (+ 3 4))        ; result: 7 (false-case)
          (if (quote()) (+ 2 3) (+ 3 4)) ; result: 7 (false-case)
          (define y '(a))
          (if (null? y) 111 222)
          (if (< 3 2) 'yes)

; inexact->exact       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (inexact->exact 7.4) ; result: 7
          (inexact->exact 7.5) ; result: 8

; integer?       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (integer? 7.4) ; result #f
          (integer? 7)   ; result #t

; lambda               ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (define y '((a)(b)(c)))
          (define w1 #t)

          ((lambda ($w1$)
             (set! w1 $w1$)
             (w1 y)) (lambda(l)(if (null? l) 100 (w1 (cdr l)))))

          ((lambda ()((lambda ($w1$)
              (set! w1 $w1$)
              (w1 y)) (lambda(l)(if (null? l) 100 (w1 (cdr l)))))))

          ((lambda(x3)x3)((lambda ()((lambda ($w1$)
              (display $w1$)(newline)
              (set! w1 $w1$)
              (w1 y)) (lambda(l)(if (null? l) 100 (w1 (cdr l))))))))

; length       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (length '(a b c d e f g))
          (length '())

; let        ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (let ((x 2)(y 3)) (* x y))

          (let ((x 2)(y 3)) 
            (let((x 7)
              (z (+ x y)))
              (* z x )))


; let*       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (let* () (+ 2 3)(* 2 3))
          (let* ((h 3)(j (+ h 5))(k (+ j 2))) (+ h j k))

          (let ((x 2)(y 3)) 
            (let*((x 7)
              (z (+ x y)))
              (* z x )))

; letrec       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (letrec ((k (lambda (x)(+ x 2))))(k 5)(k 6))
          (letrec ((g (lambda (x)(+ (h x) 1)))
                        (h (lambda (y)(+ y 3) ))) (g 7))
          (define CCFUN 1)
          (define logcond1 '(a b c))
          (letrec  ((zzw (lambda (k)
		     (set! CCFUN k)
		     (widersp (arithsimp2 logcond1) progvar indizvar) )))
              (display "logcond1:")(newline)(display logcond1))
          (letrec ((wider1 (lambda (ly)
		              (cond((null? ly) 100)
			           (else (wider1 (cdr ly)))))))
                  (wider1 '((< -1 x)(< x 256))))

          (define y '((< -1 x)(< x 256)))
          (letrec ((wider1 (lambda (l)
		     (if (null? l) 100 (wider1 (cdr l))))))
              (wider1 y))

; list          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (list 'a 'b 'c)

; list?          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (list? '(a b c))
          (list? '())
          (list? '(a . b))
          (list? '(a b c . d))

; max        ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (max '(3.9 4))

; member        ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (member '< (list '= '<= '<))
          (member '3 '(3 4))

; min          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (min '(3 4))

; negative?       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (negative? 7)
          (negative? -7)
          (negative? 0)
          (negative? "7")

; not          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (not #f)
          (not #t)
          (not '(a b))
          (not '())

; null?       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (null? '(a))
          (null? (cdr '(a)))
          (null? (cdr '((a b c))))
          (null? '())

; number?       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (number? 7)
          (number? 'a)
          (number? (+ 1 2))
          (number? "7")

; or           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (or)
          (or 3)
          (or (= 2 2)(> 2 1))
          (or (= 2 2)(< 2 1))
          (or 'a 'b)
          (or 1 2 'c '(f g))
          (or '() '(1 2))
          (or (cdr '(1)) '(1 2))
          (or(null? '())(null? '(1 2)))

; pair?     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (pair? '(a b)) ; result: #t
          (pair? '())    ; result: #f

; quote       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (quote a)
          (quote (+ 1 2))
          'a
          '()
          '(quote a)
          ; ''a  
          '145932
          '"abc"

; quasiquote       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (quasiquote a)
          (quasiquote (+ 1 2))
          `a
          `()

; quotient      ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (quotient 17 4)
          (quotient 17 -4)

; remainder     ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (remainder 13 4)   ; result: 1
          (remainder 13 -4)  ; result: 1
          (remainder -13 4)  ; result: -1
          (remainder -13 -4) ; result: -1

; reverse       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (reverse '(a b c d))
          (reverse '(0 -1 0 0))
          (reverse '())

; set!          ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
          (define xxx 0)
          (set! xxx 1)

; set-car!    ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (define x '(a b c))
          (set-car! x '(x v))
          (set-car! '(1 2 4) 3)

; set-cdr!    ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (define x2 '(a b c))
          (set-cdr! x2 '(x v))

; string<=?         ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (string<=? "Dresden" "Dresden")
          (string<=? "Dresden" "Duesseldorf")
          (string<=? "Dresde" "Berlin")

; symbol->string    ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (symbol->string 'martin)

; write             ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (write "Dresden")
          (write '(a b c))

; zero?             ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

          (zero? 7)
          (zero? 0)
]