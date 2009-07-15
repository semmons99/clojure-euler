;;;;;;;;;; problem 027 ;;;;;;;;;;
(use '[clojure.contrib.seq-utils :only (includes?)])

(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (= n 3) true
    (even? n) false
    :else (if (includes? (for [x (range 3 (+ (Math/sqrt n) 2))]
            (zero? (mod n x))) true) false true)))

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
