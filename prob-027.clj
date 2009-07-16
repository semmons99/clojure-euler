;;;;;;;;;; problem 027 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (prime?)])

(defn max-pair
  ([] nil)
  ([a b]
   (if (> (last a) (last b)) a b)))

(defn quadratic-primes [a b]
  (for [n (iterate inc 0)
        :let [result (+ (* n n) (* a n) b)]
        :while (prime? result)]
    result))

(defn prob-027 []
  (first (reduce max-pair
                 (for [a (range -999 1000)
                       b (range -999 1000)]
                   [(* a b) (count (quadratic-primes a b))]))))