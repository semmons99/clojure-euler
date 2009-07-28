;;;;;;;;;; problem 025 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (fibs)])

(defn prob-025 []
  (ffirst (filter #(= (count (str (second %))) 1000)
                  (map vector (iterate inc 0) (fibs)))))
