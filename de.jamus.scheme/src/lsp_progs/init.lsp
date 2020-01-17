(define print 
  (lambda(x)
    (display x)(newline)))

(define map 
  (lambda x
    (if (null? (cdr x))
	()
      (if (null? (cadr x))
	  ()
	(cons 
	 (eval (cons (car x) (map1 quote1 (map1 car (cdr x)))))
	 (eval (cons map (cons (car x) (map1 quote1 
					     (map1 cdr (cdr x)))))))))))

(define quote1 
  (lambda (x)
    (list 'quote x)))

(define map1 
  (lambda (f l)
    (if (null? l) 
	() 
      (cons (f (car l))(map1 f (cdr l))))))

(define atom 
  (lambda (x)
    (if (pair? x) #f #t)))
]

