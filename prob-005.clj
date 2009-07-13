;;;;;;;;;; problem 005 ;;;;;;;;;;
(defn div-by-all [n]
  (zero? (count (drop-while #(zero? (mod n %)) (range 2 21)))))

(defn prob-005 []
  (first (filter #(div-by-all %) (iterate #(+ 380 %) 380))))
