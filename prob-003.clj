;;;;;;;;;; problem 003 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.contrib.seq-utils :only (includes?)]
     '[clojure.contrib.math :only (sqrt)])
(defn prime? [n] (includes? (take-while #(<= % n) primes) n))

(defn prob-003 []
  (let [num 600851475143]
    (last (filter #(and (zero? (mod num %)) (prime? %))
		  (range 1 (+ 1 (sqrt num)))))))

