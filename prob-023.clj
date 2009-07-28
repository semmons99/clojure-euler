;;;;;;;;;; problem 023 ;;;;;;;;;;
(use '[clojure.contrib.math :only (sqrt)]
     '[clojure.contrib.seq-utils :only (flatten)])

(defn divisors [n]
  (cons 1 (distinct (flatten (for [x (range 2 (inc (sqrt n)))
                                   :when (zero? (mod n x))]
                               [x (/ n x)])))))

(defn abundant? [n]
  (> (reduce + (divisors n)) n))

(defn sum-of-abundants? [n abundants]
  (some (fn [a] (abundants (- n a)))
        (take-while #(< % n) abundants)))

(defn prob-023 []
  (let [abundants (into (sorted-set) (filter abundant? (range 12 28124)))]
    (reduce + (filter #(not (sum-of-abundants? % abundants))
                      (range 1 28124)))))
