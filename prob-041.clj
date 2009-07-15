;;;;;;;;;; problem 041 ;;;;;;;;;;
(use '[clojure.contrib.combinatorics :only (permutations)])

(defn prime? [n]
  (cond
    (< n 2) false
    (< n 4) true
    (even? n) false
    :else (let [lim (inc (Math/sqrt n))]
            (loop [x 3]
              (cond
                (> x lim) true
                (zero? (mod n x)) false
                :else (recur (inc x)))))))

(defn pandigital? [coll]
  (= (apply str (range 1 (inc (count coll))))
     (apply str (sort coll))))

(defn prob-041 []
  (first (filter prime?
                 (reverse (sort (for [i (reverse (range 1 10))
                                      p (permutations (range 1 (inc i)))
                                      :let [n (Integer. (apply str p))]]
                                  n))))))