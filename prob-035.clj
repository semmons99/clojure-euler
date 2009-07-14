;;;;;;;;;; problem 035 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.contrib.seq-utils :only (includes?)])
(defn prime? [n] (includes? (take-while #(<= % n) primes) n))

(defn circulate
  ([n] (circulate n [n]))
  ([n coll]
     (let [nums (rest (.split (str n) ""))
           circ (Integer. (apply str (cons (last nums) (butlast nums))))]
       (if (includes? coll circ)
         coll
         (recur circ (cons circ coll))))))

(defn circular-prime? [n]
  (every? prime? (circulate n)))

(defn prob-035 []
  (count (filter circular-prime? (take-while #(<= % 1000000) primes))))