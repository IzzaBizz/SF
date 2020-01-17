(define x '(1 2 3))

(do((y '(1 2 3) (cdr y))
    (s 0 (+ s (car y))))
    ((null? y) s))]