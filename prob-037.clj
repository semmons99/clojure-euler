;;;;;;;;;; problem 037 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.euler.helpers :only (prime?)])

(defn rrest [s]
  (rest (rest s)))

(defn truncate
  ([n dir] (truncate n dir []))
  ([n dir coll]
     (if (zero? n)
       coll
       (recur
        (if (= dir :right)
          (quot n 10)
          (let [a (apply str (rrest (.split (str n) "")))]
            (if (= a "") 0 (Integer. a))))
        dir (cons n coll)))))

(defn prob-037 []
  (reduce + (take 11 (for [n primes
                        :when (and (> n 10)
                                   (every? prime? (truncate n :right))
                                   (every? prime? (truncate n :left)))]
                    n))))