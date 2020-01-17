+;;; Kleines Formelmanipulationssystem
;;; ---------------------------------
;;; (c) Hartmut Fritzsche 2012


; Die match-Funktion
  
 (define atom? (lambda(o)(or(symbol? o)
                          (null? o)
			  (number? o))))

(define  match 
   (lambda(p d assignments)
       (cond ((and (null? p) (null? d))
                 ; Erfolg
              (cond ((null? assignments) #t)
                    (else assignments) ))
                 ; true, falls Muster und Datum "leer" sind
             ((or (null? p) (null? d))  #f)
                 ; Misserfolg, eine Liste ist kuerzer
             ((or (eq? (car p) '?)
                 ; == Joker-Klausel ==
                  (equal? (car p)(car d)) )  
                 ; die betrachteten Elemente sind gleich
                (match (cdr p)(cdr d) assignments) ) 
             ((eq? (car p) '+)
                  (or (match (cdr p)(cdr d) assignments)
                      (match p (cdr d) assignments)))
             ((atom? (car p)) #f)            
                 ; Misserfolg
             ((eq? (pattern-indicator (car p)) '>)
	        (match (cdr p)(cdr d) 
                   (shove-gr (pattern-variable (car p))
                             (car d)
			      assignments )) ) 
             ((eq? (pattern-indicator (car p)) '<)
               (match (cons (pull-value
                               (pattern-variable (car p))
                               assignments)
                            (cdr p))
                      d assignments))
             ((eq? (pattern-indicator (car p)) '+)
                (let ((new-assignments (shove-pl (pattern-variable (car p))
                                                 (car d)
                                                 assignments)))
                   (or (match (cdr p)(cdr d) new-assignments)
                       (match p (cdr d) new-assignments) ))) 
             ((and (eq? (pattern-indicator (car p)) 'restrict)
                   (or (and (eq? (restriction-indicator (car p)) '?)
                            (test (restriction-predicates (car p))
                                  (car d))
                            (match (cdr p) (cdr d) assignments))
                       (and (pair? (restriction-indicator (car p)))
                            (eq? (pattern-indicator(restriction-indicator(car p))) '>)
                            (test (restriction-predicates (car p))(car d))
                            (match (cdr p) (cdr d) 
                               (shove-gr 
                                  (pattern-variable
                                       (restriction-indicator (car p))) (car d) assignments))))))
             (else #f) )))

(define shove-gr 
   (lambda(variable item a-list)
      (append a-list `((,variable ,item)))))

(define pattern-indicator 
   (lambda(l)
      (car l)))

(define pattern-variable 
   (lambda(l)
      (cadr l))) 

(define shove-pl 
   (lambda(variable item a-list)
      (cond((null? a-list) `((,variable ( ,item))) )
           ((eq? variable (caar a-list))
              (cons `(,variable ,(append (cadar a-list) `( ,item)))
                     (cdr a-list)) )
           (else (cons (car a-list)
                       (shove-pl variable item (cdr a-list)) )) )))
(define pull-value 
   (lambda(variable a-list)
      (cadr (assoc variable a-list)) ))

(define restriction-indicator
  (lambda(l)
    (cadr l)))

(define restriction-predicates
  (lambda(l)
    (cddr l)))

(define eq+ (lambda(z)(eq? z '+)))

(define plusminus (lambda (x) (or (eq? x '+)(eq? x '-))))

(define test 
   (lambda(predicates  arg)
      ;(write (list '----test: predicates arg))(newline)
      (cond ((null? predicates) #t)
            ;((eval (list (car predicates) arg)(interaction-environment))
            (((eval(car predicates)(interaction-environment)) arg)
              (test  (cdr predicates) arg))
            (else #f))))

; Ersetzt ein (ggf. mehrfach vorkommendes) Element in einer (ggf. geschachtelten) Liste
(define replace 
  (lambda(old-element new-element list)
    (cond ((null? list) '())
          ((not (atom? (car list))) (cons (replace old-element new-element (car list)) 
                                          (replace old-element new-element (cdr list)))) 
          ((eq? (car list) old-element) (cons new-element (replace old-element new-element (cdr list))))
          (else (cons (car list) (replace old-element new-element (cdr list)))))))


; Datenbasis

   (define aktuelles-ziel 'differenziere)
   (define aktueller-ausdruck '())   ; wird spaeter per Nutzereingabe initialisiert

; Steuerung

   (define steuere 
     (let((temp1 '()))
      (lambda()
         (do ()
	   ((begin (set! temp1 (versuche-regeln regeln)) (if (or (null? temp1)(not temp1)) #t #f)) 
              aktueller-ausdruck)
           (newline)(write 'aktueller-ausdruck:)(newline)(write aktueller-ausdruck)(newline)
        ))))

   (define a-list '()) 
   (define a-list1 '())
   (define temp '())

(define versuche-regeln 
    (lambda(rest-regeln)
        ;(write '----versuche-regeln:)(newline) (write rest-regeln)(newline)
	(cond ((null? rest-regeln) (write a-list) '())
              ((atom? aktueller-ausdruck) '())
              ((begin (set! temp (vers-regel (car rest-regeln) aktueller-ausdruck))(if (or (not temp)(null? temp)) #f #t))
                         ;(write '----------)(write temp)
                         (set! aktueller-ausdruck temp))
              (else (versuche-regeln (cdr rest-regeln))))))

(define vers-regel 
    (lambda(regel ausdruck)
       ;(write '----vers-regel:)(newline)(write regel)(newline) (write ausdruck)(newline) 
       (let ((regel-ziel (car regel))
             (muster (cadr regel))
             (aktion (caddr regel)))
           (cond ((eq? aktuelles-ziel regel-ziel)                                       
                       (vers-regel1 ausdruck muster aktion regel))
                 (else #f)))))

(define vers-regel1 
    (lambda(ausdruck muster aktion regel)
       ;(write '---vers-regel1:) (newline)(write ausdruck)(newline) (write muster) (newline) 
       ;(write aktion)(newline)(write regel)(newline)
       (cond((atom? ausdruck) #f)
            ((begin(set! a-list (match muster ausdruck '()))(if (or(null? a-list)(not a-list)) #f #t)) 
                (feuere aktion regel))
            (else (vers-regel-liste ausdruck muster aktion regel)))))
     
(define vers-regel-liste 
  (let ((temp '())) 
   (lambda(ausdruck muster aktion regel)
       ;(write (list '----vers-regel-liste: ausdruck muster aktion regel))(newline) 
       (cond((null? ausdruck) #f)
	    ((begin (set! temp (vers-regel1 (car ausdruck) muster aktion regel))(if (or(null? temp)(not temp)) #f #t))
               (cons temp (cdr ausdruck)))
            ((begin(set! temp (vers-regel-liste (cdr ausdruck) muster aktion regel)) (if (or(null? temp)(not temp)) #f #t))
               (cons (car ausdruck) temp))
            (else #f)))))
     
(define feuere 
        (lambda(aktion regel)
           (newline)
	   (write (caddr(cdr regel)))
	   (write "    feuert:")(newline)
           (write aktion)(newline)
           (eval aktion (interaction-environment )))) 

(define match-val 
     (lambda (key a-list)
        (cadr(assoc key a-list)) ))

; Die Produktionsregeln

  (define regeln
  '( ;;;------------------------------------------------------ x-regel ------;;;      
    (differenziere
     (d (restrict (> v1) (lambda(f)(atom? f)))
        (< v1))
     1                                                          x-regel)  
    (differenziere
     (d (restrict ? (lambda(f)(and (not(atom? f))
                      (begin (set! a-list1 
                                   (match '((restrict ? (lambda(z)(eq? z '-)))
                                            (> e1)) f '()))
                             (if (or (null? a-list1)(not a-list1)) #f #t)))))
       (> v2))
       `(- (d ,(match-val 'e1 a-list1) 
            ,(match-val 'v2 a-list)))
                                                                minus-x-regel) 

    (differenziere
     (d (restrict ? (lambda(f)(atom? f))) 
        (restrict ? (lambda(f)(atom? f)))) 
     0                                                          konstanten-regel)

    (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                    (begin (set! a-list1
                                      (match '((restrict ? (lambda(z)(eq? z '+))) 
                                           (> e1)(> e2)) 
                                           f '())) (if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(+ (d ,(match-val 'e1 a-list1) ,(match-val 'v1 a-list))
          (d ,(match-val 'e2 a-list1) ,(match-val 'v1 a-list)))        
                                                                summen-regel)
    (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                    (begin 
                                    (set! a-list1
                                       (match '((restrict ? (lambda(z)(eq? z '-))) 
                                                (> e1)(> e2)) 
                                           f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(- (d ,(match-val 'e1 a-list1) ,(match-val 'v1 a-list))
          (d ,(match-val 'e2 a-list1) ,(match-val 'v1 a-list)))        
                                                                differenzen-regel)
    (differenziere 
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin
                                   (set! a-list1
                                     (match '(* (> e1)(> e2)) f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(+ (* ,(match-val 'e2 a-list1) (d ,(match-val 'e1 a-list1)
                                         ,(match-val 'v1 a-list)))
          (* ,(match-val 'e1 a-list1) (d ,(match-val 'e2 a-list1)
                                       ,(match-val 'v1 a-list))) )      
                                                                produkt-regel)
    
    ;(differenziere 
    ; (d (restrict ? (lambda (f)(and(not(atom? f))
    ;                               (begin
    ;                               (set! a-list1
    ;                                 (match '(* (> e1)(> e2)) f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
    ;    (> v1))
    ;  `(+ (* ,(match-val 'e2 a-list1) (d ,(match-val 'e1 a-list1)
    ;                                     ,(match-val 'v1 a-list)))
    ;      (* ,(match-val 'e1 a-list1) (d ,(match-val 'e2 a-list1)
    ;                                   ,(match-val 'v1 a-list))) )      
    ;                                                           quotienten-regel)

    (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin (set! a-list1
                                             (match '(expt (> e1)(> e2)) f '()))
                                          (if (or (null? a-list1)(not a-list1)) #f 
                                              (if (atom? (match-val 'e1 a-list1)) #t #f))
                                              ;(if (eq? (match-val 'e1 a-list1) (match-val 'v1 a-list)) 
                                              ;    (begin
                                              ;      (write (list 'hier (match-val 'e1 a-list1)(match-val 'v1 a-list)))
                                              ;                 #t) 
                                              ;)
                                              ))))
        (> v1))
      `(* (* ,(match-val 'e2 a-list1) (expt ,(match-val 'e1 a-list1)
                                       (- ,(match-val 'e2 a-list1) 1)))
          (d ,(match-val 'e1 a-list1)  ,(match-val 'v1 a-list)))      
                                                                potenz-regel)
    
    (differenziere
         (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin
                                     (set! a-list1
                                      (match '((> out-left) (> inner) (> out-right)) f '()))
                                     (if (or (null? a-list1)(not a-list1)) #f #t))))) (> v1) )
        (begin
          (let((innere-funktion (match-val 'inner a-list1))
               (differenziere-nach (match-val 'v1 a-list)))
            ; auessere Ableitung bilden (Substitution der inneren Funktion mit z)
            (set! aktueller-ausdruck `(d (,(match-val 'out-left a-list1) z ,(match-val 'out-right a-list1)) z)) 
            ;(newline)(write 'aeussere-ableitung:)(newline)(write aktueller-ausdruck)(newline)
            (steuere)
            ;(versuche-regeln regeln)
            ; (innere Funktion, eingesetzt in auessere Ableitung) * (Ableitung der inneren Funktion)
            ; Ruecksubstitution mittels replace-Funktion
           (set! aktueller-ausdruck  `(*  ,(replace 'z innere-funktion aktueller-ausdruck)
                 (d ,innere-funktion ,differenziere-nach)))
            (set! aktuelles-ziel 'differenziere)
            (steuere)
            )) 
                                                                ketten-regel)
    ;;;------------------------------------------------------ sin-regel ------;;;
    (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin
                                   (set! a-list1
                                     (match '(sin (> e1))  f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(* (cos ,(match-val 'e1 a-list1)) (d ,(match-val 'e1 a-list1) ,(match-val 'v1 a-list) ))  
                                                                sin-regel)
    
    ;;;------------------------------------------------------ cos-regel ------;;;
     (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin
                                   (set! a-list1
                                     (match '(cos (> e1))  f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(* (-sin ,(match-val 'e1 a-list1)) (d ,(match-val 'e1 a-list1) ,(match-val 'v1 a-list) ))  
      cos-regel)
     ;;;------------------------------------------------------ tan-regel ------;;;
      (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin
                                   (set! a-list1
                                     (match '(tan (> e1))  f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(* (/ 1 (expt (cos ,(match-val 'e1 a-list1)) 2) ) (d ,(match-val 'e1 a-list1) ,(match-val 'v1 a-list) ))  
      tan-regel)
     ;;;------------------------------------------------------ cot-regel ------;;;  
       (differenziere
     (d (restrict ? (lambda (f)(and(not(atom? f))
                                   (begin
                                   (set! a-list1
                                     (match '(cot (> e1))  f '()))(if (or (null? a-list1)(not a-list1)) #f #t)))))
        (> v1))
      `(* (/ -1 (expt (sin ,(match-val 'e1 a-list1)) 2) ) (d ,(match-val 'e1 a-list1) ,(match-val 'v1 a-list) ))  
      cot-regel)
     
    ;;;------------------------------------------ veraendere-ziel-regel ------;;;
    (differenziere
     ((+ f))
      (let() (set! aktuelles-ziel 'vereinfache) (match-val 'f a-list))
                                                               veraendere-ziel-regel)

    (vereinfache (expt ? 0)  1                                 exp-0-regel)
    (vereinfache (expt (> b) 1)  (match-val 'b a-list)         exp-1-regel)
    (vereinfache (* ? 0)  0                                    mul-0-regel)
    (vereinfache (* 0 ?)  0                                    null-mul-regel)
    (vereinfache (* 1 (> v1))  (match-val 'v1 a-list)          eins-mul-regel)
    (vereinfache (* (> v1) 1)  (match-val 'v1 a-list)          mul-eins-regel)
    (vereinfache (+ 0 (> v1))  (match-val 'v1 a-list)          null-sum-regel)
    (vereinfache (+ (> v1) 0)  (match-val 'v1 a-list)          sum-null-regel)
    (vereinfache (* (restrict (> v1)(lambda(f)(number? f)))
                    (restrict (> v2)(lambda(f)(number? f))) )
                 (* (match-val 'v1 a-list)
                    (match-val 'v2 a-list))                    num-prod-regel)
    (vereinfache (- (restrict (> v1)(lambda(f)(number? f)))
                    (restrict (> v2)(lambda(f)(number? f))) )
                 (- (match-val 'v1 a-list)
                    (match-val 'v2 a-list))                    num-num-dif-regel)
    (vereinfache (- (restrict (> v1)(lambda(f)(number? f))) )
                 (- 0 (match-val 'v1 a-list))                   minus-num-regel)
    (vereinfache ((restrict (> op)(lambda(f)(plus f))) (restrict (> v1)(lambda(f)(number? f)))
                    (restrict (> v2)(lambda(f)(number? f))) )
                 (+ (match-val 'v1 a-list)
                    (match-val 'v2 a-list))                    num-num-plus-regel)
    (vereinfache (* (restrict (> v1)(lambda(f)(number? f)))
                    (restrict (> exp)(lambda(g)
                                       (and(not(atom? g))
                                           (begin
                                             (set! a-list1
                                                (match '(* (restrict (> v2)
                                                              (lambda(f)
                                                                 (number? f)))
                                                            (> e))
                                                        g
                             '()))(if (or (null? a-list1)(not a-list1)) #f #t))))))
                  `(* ,(* (match-val 'V1 a-list)(match-val 'v2 a-list1))
                      ,(match-val 'e a-list1))                 num-num-prod-regel)
    
     (vereinfache (* (restrict (> exp1)(lambda(f)(and (pair? f)
                                                      (eq? (car f) '*)
                                                      (number? (cadr f))
                                                      (null? (cdddr f)))))
                    (restrict (> exp2)(lambda(g)(and(pair? g)
                                                    (eq? (car g) '*)
                                                    (number? (cadr g))
                                                    (null? (cdddr g))))))
                  `(* ,(* (cadr(match-val 'exp1 a-list))(cadr(match-val 'exp2 a-list)))
                      (* ,(caddr (match-val 'exp1 a-list)) ,(caddr (match-val 'exp2 a-list))))          
                                                               prod-prod-prod-regel)
  ))
         
(define inf-to-pre
   (lambda(e)         ; Infix-Notation -> Präfix-Notation
      (let ((alist '()))
         (cond ((atom? e) e)
               ((begin (set! alist (match '((> v)) e '())) alist)
                (inf-to-pre (match-val 'v alist )) )
               ((begin (set! alist (match '((+ l) 
                                            (restrict (> op) groundop)
                                            (restrict (> v) plusminus)
                                            (> el)
                                            (+ r)) e '())) alist)
                 (inf-to-pre `( ,@(match-val 'l alist) 
                                ,(match-val 'op alist) 
                                (,(match-val 'v alist) ,(match-val 'el alist))
                                ,@(match-val 'r alist) )))
               ((begin (set! alist (match '((+ l) (restrict ? eq+) (+ r)) e  '())) alist)
                 `(+ ,(inf-to-pre (match-val 'l  alist ))
                     ,(inf-to-pre (match-val 'r  alist )) ))
               ((begin (set! alist (match '((+ l) - (+ r)) (reverse e)  '())) alist)
                 `(- ,(inf-to-pre (reverse(match-val 'r alist )))
                     ,(inf-to-pre (reverse(match-val 'l   alist ))) ))
               ((begin (set! alist (match '((+ l) * (+ r)) e '())) alist)
                 `(* ,(inf-to-pre (match-val 'l  alist ))
                     ,(inf-to-pre (match-val 'r  alist )) ))
               ((begin (set! alist (match '((+ l) / (+ r)) (reverse e) '())) alist)
                 `(/ ,(inf-to-pre (reverse(match-val 'r alist )))
                     ,(inf-to-pre (reverse(match-val 'l  alist ))) ))
               ((begin (set! alist (match '((+ l) ^ (+ r)) (reverse e) '())) alist)
                 `(expt ,(inf-to-pre (reverse(match-val 'r alist)))
                        ,(inf-to-pre (reverse(match-val 'l  alist ))) ))
               ((begin (set! alist (match '(- (+ r)) e '())) alist)
                 `(- ,(inf-to-pre  (match-val 'r  alist )) ))
               ((begin (set! alist (match '((restrict (> var) trigo) (> plist)) e '())) alist)
                 `(,(match-val 'var alist) ,(inf-to-pre  (match-val 'plist  alist )) ))
               (else e) ))))  ; andere Ausdrücke werden nicht transformiert 

(define groundop
  (lambda(x)(or (eq? x '+)(eq? x '-)(eq? x '*)(eq? x '/))))

(define plus 
   (lambda(x)
      (eq? x '+)))

(define trigo 
   (lambda(x)
      (or (eq? x 'sin)(eq? x 'cos))))

(define p-t-i (lambda(exp)
    (cond((atom? exp) exp) ;(list exp))
         ;(else (append 
         ((eq? 'cos (car exp))
          (list 'cos (list (p-t-i (cadr exp)))))
         ((and (atom? (car exp))(null? (cddr exp)))
          `(,(car exp),(p-t-i (cadr exp))))
         (else (list
                  (p-t-i (cadr exp))
                  ;(list (cond((eq?(car exp) 'expt) '^)
                  (cond((eq?(car exp) 'expt) '^)
                       (else(car exp))) ;)
                  (p-t-i (caddr exp))))))) 

; Aufruf:
  (let((te '())
       (a-list1 '()))
     (write "-- Formelmanipulationssystem \"ANALYSIS\" --")(newline)
     (write "zu differenzierender Ausdruck>")
     ;(set! te (list (read)))
     ;(set! te '((3 * x ^ 2 + 5) ^ 4))
     ;(set! te '(x ^ (- 1)))
     (set! te '(a * x ^ 4 + b * x ^ 2))
     ;(set! te '(x ^ 2 - x + sin(x)))
     ;(set! te '(2 * x ^ 4 - x ^ 3 + 8 * x ^ 2 + 10 * x + 10)) 
     ;(write "differenzieren nach>")
     ;(set! aktueller-ausdruck `(d ,(inf-to-pre te) ,(read)))
     (set! aktueller-ausdruck `(d ,(inf-to-pre te) x))(newline)
     ;(set! aktueller-ausdruck `(d (* x (cos x)) x))(newline)
     ;(set! aktueller-ausdruck '(* 2 x)) 
     ;(set! aktueller-ausdruck `(+ 10 (+ 5 2)))(newline)
     (write aktueller-ausdruck)(newline)
     (steuere)
     (newline)
     (write "RESULTAT:")(newline)
     (write (p-t-i aktueller-ausdruck)))



; > (load "analysis.lsp")
; ;; Datei analysis.lsp wird geladen...
; 
; -- Formelmanipulationssystem "ANALYSIS" --
; zu differenzierender Ausdruck>
; (2 * x ^ 4 + x ^ 3 + 8 * x ^ 2 + 10 * x + 10)                        
; differenzieren nach>x
; SUMMEN-REGEL  feuert
; SUMMEN-REGEL  feuert
; SUMMEN-REGEL  feuert
; SUMMEN-REGEL  feuert
; KONSTANTEN-REGEL  feuert
; PRODUKT-REGEL  feuert
; KONSTANTEN-REGEL  feuert
; PRODUKT-REGEL  feuert
; KONSTANTEN-REGEL  feuert
; PRODUKT-REGEL  feuert
; X-REGEL  feuert
; KONSTANTEN-REGEL  feuert
; POTENZ-REGEL  feuert
; X-REGEL  feuert
; POTENZ-REGEL  feuert
; X-REGEL  feuert
; POTENZ-REGEL  feuert
; X-REGEL  feuert
; VERAENDERE-ZIEL-REGEL  feuert
; MUL-0-REGEL  feuert
; MUL-0-REGEL  feuert
; MUL-0-REGEL  feuert
; MUL-EINS-REGEL  feuert
; MUL-EINS-REGEL  feuert
; MUL-EINS-REGEL  feuert
; MUL-EINS-REGEL  feuert
; NULL-SUM-REGEL  feuert
; NULL-SUM-REGEL  feuert
; NULL-SUM-REGEL  feuert
; SUM-NUL-REGEL  feuert
; NUM-DIF-REGEL  feuert
; NUM-DIF-REGEL  feuert
; NUM-DIF-REGEL  feuert
; EXP-1-REGEL  feuert
; NUM-NUM-PROD-REGEL  feuert
; NUM-NUM-PROD-REGEL  feuert
; 
; NIL 
; RESULTAT:
; 
; (8 * X ^ 3 + 3 * X ^ 2 + 16 * X + 10)
; ;; Datei analysis.lsp ist geladen.
; T
; > 

