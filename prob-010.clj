;;;;;;;;;; problem 010 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prob-010 []
  (reduce + (take-while #(< % 2000000) primes)))
