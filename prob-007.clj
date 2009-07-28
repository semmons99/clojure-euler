;;;;;;;;;; problem 007 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prob-007 []
  (nth primes 10000))
