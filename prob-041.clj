;;;;;;;;;; problem 041 ;;;;;;;;;;
(use '[clojure.contrib.combinatorics :only (permutations)]
     '[clojure.contrib.seq-utils :only (includes?)])

(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (= n 3) true
    (even? n) false
    :else (if (includes? (for [x (range 3 (+ (Math/sqrt n) 2))]
            (zero? (mod n x))) true) false true)))

(defn pandigital? [coll]
  (= (apply str (range 1 (inc (count coll))))
     (apply str (sort coll))))

(defn prob-041 []
  (first (filter prime?
                 (reverse (sort (for [i (reverse (range 1 10))
                                      p (permutations (range 1 (inc i)))
                                      :let [n (Integer. (apply str p))]]
                                  n))))))