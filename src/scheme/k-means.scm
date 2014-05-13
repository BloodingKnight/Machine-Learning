(define nil '())

(define (filter predicate alist)
  (cond ((null? alist) nil)
        ((predicate (car alist))
         (cons (car alist)
               (filter predicate (cdr alist))))
        (else (filter predicate (cdr alist)))))

(define (accumulate op initial alist)
  (if (null? alist)
      initial
      (op (car alist)
          (accumulate op initial (cdr alist)))))

(define (accumulate-n op initial alist)
  (if (null? alist)
      initial
      (accumulate-n op
                    (op initial (car alist))
                    (cdr alist))))

(define (generalize properties)
  "generalize points"
  (display "Not Implemented")
  (newline))

(define (get alist index)
  (cond ((= index 0) (car alist))
        ((> index 0) (get (cdr alist) (- index 1)))))

(define (min-index alist)
  (define (min-index-iter index i value alist)
    (cond ((null? alist) index)
          ((< (car alist) value) (min-index-iter i (+ i 1) (car alist) (cdr alist)))
          (else (min-index-iter index (+ i 1) value (cdr alist)))))

  (min-index-iter 0 0 (car alist) alist))

(define (random-keys k properties)
  "make k random keys from properties"
  (let ((len (length properties)))
    (if (= k 0)
        nil
        (let ((key (get properties (random len))))
          (cons
           key
           (random-keys (- k 1) (remove key properties)))))))

(define (square x)
  (* x x))

(define (distance a b)
  (define (distance-iter a b d)
    (if (null? a)
        d
        (distance-iter
         (cdr a)
         (cdr b)
         (+ (square (- (car a) (car b))) d))))

  (sqrt (distance-iter a b 0)))

(define (cluster-points properties keys)
  (let ((result (make-list (length keys) '())))
    (for-each
     (lambda (x)
  (map
   min-index
   (accumulate
    (lambda (point rest)
      (cons
       (if (null? point)
           nil
           (accumulate
            (lambda (x y)
              (cons
               (if (null? x) nil (distance x point))
               y))
            nil
            keys))
       rest))
    nil
    properties))))))

(accumulate + 0 '(1 2 3 4))
(map square '(1 2 3 4))

(define (update-points properties keys)
  "update keys, if new keys equal old keys, then finish"
  (let ((clusters (cluster-points properties keys))
        (new-keys (map central-keys clusters)))
    (if (equal? keys new-keys)
        keys
        (update-points properties new-keys))))

(define (add-list alist blist)
  (if (null? alist)
      nil
      (cons (+ (car alist) (car blist))
            (add-list (cdr alist) (cdr blist)))))

(define (central-keys alist)
  (map
   (lambda (x)
     (/ x (length alist)))
   (accumulate add-list (car alist) (cdr alist))))

(define (k-means properties k)
  (let ((keys (random-keys properties)))
    (update-points properties keys)))
