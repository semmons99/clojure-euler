;;;;;;;;;; problem 041 ;;;;;;;;;;
(use '[clojure.contrib.combinatorics :only (permutations)]
     '[clojure.euler.helpers :only (prime?)])

(defn pandigital? [coll]
  (= (apply str (range 1 (inc (count coll))))
     (apply str (sort coll))))

(defn prob-041 []
  (first (filter prime?
                 (reverse (sort (for [i (reverse (range 1 10))
                                      p (permutations (range 1 (inc i)))
                                      :let [n (Integer. (apply str p))]]
                                  n))))))