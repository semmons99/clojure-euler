;;;;;;;;;; problem 056 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn digital-sum [n]
  (reduce + (map #(Integer. %) (rest (.split (str n) "")))))

(defn prob-056 []
  (reduce max (for [a (range 1 100)
                    b (range 1 100)]
                (digital-sum (expt a b)))))