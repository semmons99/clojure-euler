;;;;;;;;;; problem 015 (pascal's triangle) ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])
(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn choose [n r]
    (/ (factorial n) (expt (factorial r) 2)))

(defn prob-015 []
  (choose (* 20 2) 20))

