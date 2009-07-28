;;;;;;;;;; problem 049 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (prime?)])

(defn interesting? [coll]
    (if (and (= (- (coll :c) (coll :b)) (- (coll :b) (coll :a)))
             (= (sort (.split (str (coll :a)) ""))
                (sort (.split (str (coll :b)) ""))
                (sort (.split (str (coll :c)) ""))))
      true
      false))

(defn prob-049 []
  (second
   (for [a (filter prime? (range 1000 10000))
         i (range 1 (- 10000 a))
         :let [b (+ a i)
               c (+ b i)]
         :when (and (prime? b)
                    (prime? c)
                    (interesting? {:a a, :b b, :c c}))]
     (str a b c))))
