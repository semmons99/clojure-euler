;;;;;;;;;; problem 037 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.contrib.seq-utils :only (includes?)])

(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (= n 3) true
    (even? n) false
    :else (if (includes? (for [x (range 3 (+ (Math/sqrt n) 2))]
            (zero? (mod n x))) true) false true)))
(def prime? (memoize prime?))

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