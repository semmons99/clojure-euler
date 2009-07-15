;;;;;;;;;; problem 027 ;;;;;;;;;;
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