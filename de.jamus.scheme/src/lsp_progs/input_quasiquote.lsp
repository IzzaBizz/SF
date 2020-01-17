(quasiquote (3 (unquote (+ 3 4))))
`(3 ,(+ 3 4))
(quasiquote(a (unquote (list 1 2 (quasiquote (+ 3 (unquote (+ 4 5))))))))
`(a ,(list 1 2 `(+ 3 ,(+ 4 5)))) 
(quasiquote(a (quasiquote (b (unquote(+ 1 2)) (unquote (foo (unquote(+ 1 3)) d)) e)) f))]