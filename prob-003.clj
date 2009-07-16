;;;;;;;;;; problem 003 ;;;;;;;;;;
(use '[clojure.contrib.math :only (sqrt)]
     '[clojure.euler.helpers :only (prime?)])

(defn prob-003 []
  (let [num 600851475143]
    (last (filter #(and (zero? (mod num %)) (prime? %))
                  (range 1 (+ 1 (sqrt num)))))))