;;;;;;;;;; problem 048 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn prob-048 []
  (let [n (str (reduce + (map #(expt % %) (range 1 1001))))]
    (.substring n (- (count n) 10))))