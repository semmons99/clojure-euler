;;;;;;;;;; problem 015 (pascal's triangle) ;;;;;;;;;;
(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn choose [n r]
  (/ (factorial n) (* (factorial r) (factorial (- n r)))))

(defn prob-015 []
  (choose (* 20 2) 20))
