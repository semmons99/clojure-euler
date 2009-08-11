;;;;;;;;;; problem 069 ;;;;;;;;;;
(use '[clojure.contrib.def :only (defvar)])

(defvar primes [2 3 5 7 11 13 17 19 23])

(defn prob-069 []
  (reduce max (for [a (range 1 (inc (count primes)))
                    :let [b (take a primes)
                          c (reduce * b)]
                    :when (< c 1000000)]
                c)))