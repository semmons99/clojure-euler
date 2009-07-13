;;;;;;;;;; problem 001 ;;;;;;;;;;
(defn multiple-of-3 [n] (= 0 (mod n 3)))
(defn multiple-of-5 [n] (= 0 (mod n 5)))

(defn prob-001 []
  (reduce + (filter #(or (multiple-of-3 %) (multiple-of-5 %)) (range 1000))))
