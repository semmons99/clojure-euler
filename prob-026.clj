;;;;;;;;;; problem 026 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn order [a n]
  (first (filter #(= 1 (mod (expt a %) n)) (iterate inc 1))))

(defn decimal-period [n]
  (cond (= 1 n) 0
    (zero? (rem n 2)) (decimal-period (/ n 2))
    (zero? (rem n 5)) (decimal-period (/ n 5))
    :else (order 10 n)))

(defn prob-026 []
  (let [nums (range 1 1000)
        periods (map decimal-period nums)]
    ((zipmap periods nums) (apply max periods))))
