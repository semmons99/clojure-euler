;;;;;;;;;; problem 053 ;;;;;;;;;;
(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn choose [n r]
  (/ (factorial n) (* (factorial r) (factorial (- n r)))))

(defn prob-053 []
  (count (for [n (range 1 101)
               r (range 1 (inc n))
               :let [c (choose n r)]
               :when (> c 1000000)]
           c)))
