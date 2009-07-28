;;;;;;;;;; problem 009 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn triplet? [a b c]
  (= (+ (expt a 2) (expt b 2)) (expt c 2)))

(defn prob-009 []
  (first (for [a (range 1 333)
               b (range (+ a 1) 500)
               :let [c (- 1000 a b)]
               :when (triplet? a b c)]
           (* a b c))))
