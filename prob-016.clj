;;;;;;;;;; problem 016 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn prob-016 []
  (reduce + (map #(Integer. %) (rest (.split (str (expt 2 1000)) "")))))
