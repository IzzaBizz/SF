;;;                                                                 ;;;
;;;    JamusHCI (Hornklausel-Interpreter fuer das Projekt Jamus)    ;;;
;;;    (c) 2013 Hartmut Fritzsche                                   ;;;

;; atom? : Symbole, Zahlen und die leere Liste sind Atome
(define atom? 
  (lambda(o)
    (or 
     (symbol? o)
     (null? o)
     (number? o))))

;; neq : liefert #t, wenn x zu y nicht eq?-gleich ist, sonst #f
(define neq?
  (lambda(x y)
    (not (eq? x y)))) 
    
;; jede Spalte der inneren Listen entspricht einem level
(define neuevarn '((X (X1 X2 X3 X4 X5))
                   (Y (Y1 Y2 Y3 Y4 Y5))
                   (Z (Z1 Z2 Z3 Z4 Z5))
                   (W (W1 W2 W3 W4 W5))
                   (_A (_A1 _A2 _A3 _A4 _A5))
                   (_B (_B1 _B2 _B3 _B4 _B5))
                   (_X (_X1 _X2 _X3 _X4 _X5))
                   (_Y (_Y1 _Y2 _Y3 _Y4 _Y5))
                   (_Z (_Z1 _Z2 _Z3 _Z4 _Z5))
                   (_U (_U1 _U2 _U3 _U4 _U5))
                   (_V (_V1 _V2 _V3 _V4 _V5))
                   (_W (_W1 _W2 _W3 _W4 _W5))))

;; liefert #f, wenn das Argument keine Variable ist         
(define variablep 
  (lambda(x)
    (member x '(_A _A1 _A2 _A3 _A4 _A5
                _B _B1 _B2 _B3 _B4 _B5
                X X1 X2 X3 X4 X5
                Y Y1 Y2 Y3 Y4 Y5
                Z Z1 Z2 Z3 Z4 Z5
                W W1 W2 W3 W4 W5
                _X _X1 _X2 _X3 _X4 _X5
                _Y _Y1 _Y2 _Y3 _Y4 _Y5
                _Z _Z1 _Z2 _Z3 _Z4 _Z5
                _U _U1 _U2 _U3 _U4 _U5
                _V _V1 _V2 _V3 _V4 _V5
                _W _W1 _W2 _W3 _W4 _W5)) ))
                
(define kommt_vor 
  (lambda(elt ausd)
    (cond
      ((eq? ausd elt) #t)
      ((atom? ausd) #f)
      (else (or(kommt_vor elt (car ausd))  
               (kommt_vor elt (cdr ausd)))))))
               
;; kopiere : ersetzt alle Variablen in l durch die dem aktuellen level
;;           entsprechenden neuen Variablen
(define kopiere 
  (lambda(l level)
    ;(write "-- kopiere" )(newline)
    ;(write "     l: ")(write l)(newline) 
    ;(write "     level: ")(write level)(newline) 
    (letrec((kopiere1 (lambda(l)
                        ;(write "---- kopiere1" )(newline)
                        ;(write "     l: ")(write l)(newline)
                        (cond((null? l)'()) 
                             ((atom? l)
                              (cond((variablep l)(getvar l level))  
                                   (else l)))
                             (else (cons (kopiere1 (car l))
                                         (kopiere1 (cdr l))))
                        )) ))
      (kopiere1 l))))

;; getvar : hole den Wert der Variablen v fuer angegebenes level
(define getvar
  (lambda(v level)
    ;(write "-- getvar" )(newline)
    ;(write "     v: ")(write v)(newline)
    ;(write "     level: ")(write level)(newline)
    (getntes level 
             ; (get v 'neuevarn)
             (cadr (assoc v neuevarn)) )))
     
;; getntes : gibt das nte Element der Liste l zurueck
;;           Rueckgabewert ist ein Variablensymbol
(define getntes 
  (lambda(n l)
    ;(write "-- getntes" )(newline)
    ;(write "     n: ")(write n)(newline)
    ;(write "     l: ")(write l)(newline)
    (cond((null? l) (write "n too large for list")(newline))
         ((eq? n 1)(car l))
         (else (getntes (- n 1) (cdr l)))) ))
         
;; Prolog-Interpreter
;; startet mit Klauselliste c und Goalliste g
(define prolog 
  (lambda(c g)
    (newline)(display "clauses : ")(newline) (write c)(newline)
             (display "goal    : ")(newline) (write g)(newline)(newline)
    (letrec
      ((clauses c)
       (ziel g)
       (b '())       ; Bindungen
       ;(level 0)    ; Ebene
       (neueb '())
       (u '())
       (add_paar (lambda(term var)
       	             ;(write "-- add_paar" )(newline)
                     ;(write "     term: ")(write term)(newline)
                     ;(write "     var: ")(write var)(newline)
                     (cond((kommt_vor var term) 'nicht_unifizierbar)
                          (else (set! u (cons (cons var term)
                                              (subst1 u term var))))) )) 
       (unifiziere1 (lambda(l1 l2)
                      ;(write "-- unifiziere1" )(newline)
                      ;(write "     l1: ")(write l1)(newline)
                      ;(write "     l2: ")(write l2)(newline)
                      ;(write "      u: ")(write u)(newline)
                 (cond((eq? l1 l2) '())
                      ((and(null? l1)(null? l2)) '())
                      ;((or (null? l1)(null? l2)) 'fail)
                      ((variablep l1) (add_paar l2 l1))
                      ((variablep l2) (add_paar l1 l2))
                      ((or(atom? l1)(atom? l2)) 'fail)
                      ((neq? (unifiziere1 (subst (car l1) u) 
                                          (subst (car l2) u)) 'fail)
                       (unifiziere1 (cdr l1)(cdr l2)))
                      (else 'fail))))
                       ; unifiziere2 : ruft unify auf,
       ;               gibt Unifikator | 'nicht_unifizierbar zur�ck 
       (unifiziere2  (lambda (l1 l2 b level)
                       ;(write "-- unifiziere2" )(newline)
                       ;(write "     l1: ")(write l1)(newline)
                       ;(write "     l2: ")(write l2)(newline)
                       ;(write "     b:  ")(write b)(newline) 
                       (cond((neq? (car l1)(car l2)) 'nicht_unifizierbar) 
                       (else (set! u '())
                              ; (let((u '()))
                               ; (set! u (unify1 
                               ;               (kopiere (cdr l1)
                               ;                        (+ level 1))   
                               ;               (subst (cdr l2) b)
                               ;               '()))
                               (cond((neq? 
                                      (unifiziere1 (kopiere (cdr l1)
                                                            (+ level 1))   
                                                   (subst (cdr l2) b))
                               ;(cond((neq? u
                                      ; (unify1 
                                      ;        (kopiere (cdr l1)
                                      ;                 (+ level 1))  
                                      ;        (subst (cdr l2) b)
                                      ;        '())
                                           'fail) 
                                      ;'nicht_unifizierbar)
                                      (kombiniere u b))
                            (else 'nicht_unifizierbar)  ) )) ))  
       (loese  (lambda(gl b level)
                  ;(write "-- loese" )(newline)
                  ;(write "     gl: ")(write gl)(newline)
                  ;(write "     b: ")(write b)(newline)
                  ;(write "     level:  ")(write level)(newline) 
                  (cond((null? gl)(zeige_b b ziel)) 
                       (else (loese1 clauses gl b level)))))
       (loese1 (lambda(r gl b level)
          ; (write "-- loese1" )(newline)
          ; (write "     r: ")(write r)(newline)
          ; (write "     gl: ")(write gl)(newline)
          ; (write "     b: ")(write b)(newline)
          ; (write "     level:  ")(write level)(newline) 
           (cond((null? r) '())
                (else (cond((neq? (begin 
                                    (set! neueb 
                                          (unifiziere2
                                             (caar r)    ; Versuchskopf 
                                             (car gl)    ; aktuelles Teilziel
                                             b
                                             level))         ; aktuelle Bindungen
                                    neueb) 
                                  'nicht_unifizierbar)
                                            ;(write "     + neueb: ")(write neueb)(newline) 
                                            (loese (append (kopiere (cdar r)
                                                                    (+ level 1))
                                                           (cdr gl))
                                                   neueb
                                                   (+ level 1)
                                                   ))
                           ;(else (write "< nicht unifizierbar" )(newline))
                           )
                      ;(write "> suche weiter" )(newline)
                      (loese1 (cdr r) gl b level))))))
      ; Aufruf       
      (loese g b 0)
           )))
           
;; zeige_b : zeigt die Bindungen in b an
(define zeige_b
  (lambda(b ziel)
    ;(write "-- zeige_b" )(newline)
    ;(write "     b: ")(write b)(newline)
    ;(write "     ziel: ")(write ziel)(newline)
    (mapcar zeige_paar b ziel)
    (newline)))
    
(define mapcar
  (lambda(f b z)
    (cond((null? b)'())
         (else (f (car b) z)
               (mapcar f (cdr b) z)))))

;; zeige_paar
(define zeige_paar
  (lambda(p ziel)
    (cond((ist_vorhanden (car p) ziel)
          (write (car p))
;         (display " = ")(write (cdr p))(display " ;")(newline)
          (write " = ")(write (cdr p))(write " ")(newline)
		  
)) ))

(define ist_vorhanden
  (lambda(p ziel)
    ;(write "-- ist_vorhanden" )(newline)
    ;(write "     p: ")(write p)(newline)
    ;(write "     ziel: ")(write ziel)(newline)
    (cond ((null? ziel) #f)
          ((eq? p ziel) #t)
          ((atom? ziel) #f)
          (else (or (ist_vorhanden p (car ziel))
                    (ist_vorhanden p (cdr ziel))) )) ))
                    
 ; subst : substituiere 
(define subst
  (lambda(ausd l)
    ;(write "-- subst" )(newline)
    ;(write "     ausd: ")(write ausd)(newline)
    ;(write "     l: ")(write l)(newline)
    (cond 
      ((null? l) ausd)
      (else (subst1 (subst ausd (cdr l))
                    (cdar l)           ; var.wert rein
                    (caar l)            ; var.name raus
                    ) )) ))
                    
; subst1 : substituiere y (name) �berall in l durch x (wert)
(define subst1
  (lambda(l x y) 
    ;(write "-- subst1" )(newline)
    ;(write "     l: ")(write l)(newline)
    ;(write "     x: ")(write x)(newline)
    ;(write "     y: ")(write y)(newline)
    (cond 
      ((eq? l y) x)
      ((atom? l) l)
      (else (cons (subst1 (car l) x y ) 
                  (subst1 (cdr l) x y)))) ))
                  
; kombiniere : verbindet zwei Substitutionen
(define kombiniere 
  (lambda(s1 s2)
    ;(write "-- kombiniere" )(newline)
    ;(write "     s1: ")(write s1)(newline)
    ;(write "     s2: ")(write s2)(newline)
    (cond((null? s1) s2)
         (else (cons (car s1)
                     (subst1 (kombiniere (cdr s1) s2)
                             (cdar s1)
                             (caar s1)))))))  
                                   

;(prolog '(((reverse1 () _A _A))
;          ((reverse1 (cons _X  _Y) _A _U)(reverse1 _Y (cons _X _A) _U))) 
;        
;        '((reverse1 (cons a (cons b (cons c ()))) () _X))) 
        
;;; Erprobung des Interpreters
;; Beispiel 
(prolog '(((append () _X _X))
          ((append (cons _U _X) _Y (cons _U _Z))(append _X _Y _Z)))
        '((append (cons a _B) _A (cons a (cons b ())))))
                              
(eq? '() '())
]
