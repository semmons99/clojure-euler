;;;;;;;;;; problem 006 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn prob-006 []
  (let [nums (range 1 101)]
    (int (- (expt (reduce + nums) 2)
            (reduce + (map #(expt % 2) nums))))))
