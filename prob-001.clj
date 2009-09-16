;;;;;;;;;; problem 001 ;;;;;;;;;;
(defn multiple-of [n] #(zero? (mod % n)))
(def multiple-of-3 (multiple-of 3))
(def multiple-of-5 (multiple-of 5))

(defn prob-001 []
  (reduce + (filter #(or (multiple-of-3 %) (multiple-of-5 %)) (range 1000))))
