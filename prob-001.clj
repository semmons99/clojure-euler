;;;;;;;;;; problem 001 ;;;;;;;;;;
(defn multiple-of [n] #(zero? (mod % n)))
(def multiple-of-3 (multiple-of 3))
(def multiple-of-5 (multiple-of 5))
(defn multiple-of-3-or-5 [n] (or (multiple-of-3 n) (multiple-of-5 n)))

(defn prob-001 []
  (reduce + (filter multiple-of-3-or-5 (range 1000))))
