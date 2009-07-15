;;;;;;;;;; problem 003 ;;;;;;;;;;
(use '[clojure.contrib.seq-utils :only (includes?)]
     '[clojure.contrib.math :only (sqrt)])
(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (= n 3) true
    (even? n) false
    :else (if (includes? (for [x (range 3 (+ (Math/sqrt n) 2))]
            (zero? (mod n x))) true) false true)))

(defn prob-003 []
  (let [num 600851475143]
    (last (filter #(and (zero? (mod num %)) (prime? %))
                  (range 1 (+ 1 (sqrt num)))))))
