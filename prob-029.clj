;;;;;;;;;; problem 029 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn prob-029 []
  (count (distinct (for [a (range 2 101)
                         b (range 2 101)]
                     (expt a b)))))
