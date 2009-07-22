;;;;;;;;;; problem 028 ;;;;;;;;;;
(use '[clojure.contrib.seq-utils :only (flatten)])

(defn prob-028 []
  (inc (reduce + (flatten
                   (for [n (range 3 1002 2)
                         :let [c1 (* n n)
                               c2 (inc (- c1 n))
                               c3 (inc (- c2 n))
                               c4 (inc (- c3 n))]]
                     [c1 c2 c3 c4])))))
