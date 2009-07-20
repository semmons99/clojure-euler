;;;;;;;;;; problem 050 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.euler.helpers :only (prime?)])

(defn primes-upto [n]
  (loop [i 1]
    (if (> (reduce + (take i primes)) n)
      (dec i)
      (recur (inc i)))))

(defn prob-050 []
  (let [ps (take (primes-upto 1000000) primes)]
    (first (for [i (reverse (range 1 (inc (count ps))))
                 p (reverse (partition i 1 ps))
                 :let [n (reduce + p)]
                 :when (prime? n)]
             n))))