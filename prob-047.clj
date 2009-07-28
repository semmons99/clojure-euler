;;;;;;;;;; problem 047 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (prime?)]
     '[clojure.contrib.math :only (sqrt)])

(defn factors [n]
  (reduce into (for [x (range 1 (inc (sqrt n)))
                     :when (zero? (mod n x))]
                 [x (/ n x)])))

(defn prime-factors [n]
  (filter prime? (distinct (factors n))))
(def prime-factors (memoize prime-factors))

(defn prob-047 []
  (loop [n 210]
    (if (= 4
           (count (prime-factors n))
           (count (prime-factors (+ n 1)))
           (count (prime-factors (+ n 2)))
           (count (prime-factors (+ n 3))))
      n
      (recur (inc n)))))
