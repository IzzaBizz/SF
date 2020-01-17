


(define hanoi (lambda(a b c)
  (if (null?(cdr(cdr a)))
      (move a b)
      (begin (hanoi (cons (car a)(cdr(cdr a))) c b)
             (move a b)
             (hanoi (append c (cdr(cdr a))) b (cons (car a) ()))))))