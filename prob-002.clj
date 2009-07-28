;;;;;;;;;; problem 002 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (fibs)])

(defn prob-002 []
  (reduce + (filter #(even? %) (take-while #(< % 4000000) (fibs)))))
