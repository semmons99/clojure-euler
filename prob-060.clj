;;;;;;;;;; problem 060 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.contrib.def :only (defvar)]
     '[clojure.euler.helpers :only (prime?)])

(defn concat-prime? [ab]
  (let [a (str (first ab))
        b (str (last ab))
        n1 (Integer. (str a b))
        n2 (Integer. (str b a))]
    (and (prime? n1) (prime? n2))))

(defn all-concat-prime? [n ps]
  (every? concat-prime? (partition 2 (interleave ps (repeat n)))))

(defvar prime-combos
  (let [ps (rest (take-while #(< % 10000) primes))]
    (for [a ps
          b (filter #(> % a) ps)
          :when (all-concat-prime? b [a])
          c (filter #(> % b) ps)
          :when (all-concat-prime? c [a b])
          d (filter #(> % c) ps)
          :when (all-concat-prime? d [a b c])
          e (filter #(> % d) ps)
          :when (all-concat-prime? e [a b c d])]
      [a b c d e])))
  
(defn prob-060 []
  (reduce + (first prime-combos)))