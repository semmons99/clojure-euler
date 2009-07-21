;;;;;;;;;; problem 051 ;;;;;;;;;;
(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.euler.helpers :only (prime?)])

(defn digits [n]
  (map #(Integer. %) (rest (.split (str n) ""))))

(defn find-repeating [n]
  (let [ds (digits n)]
    (first (for [d ds
                 :when (= 3 (count (filter #(= d %) ds)))]
             d))))

(defn family [n]
  (let [rpt (find-repeating n)]
    (if (nil? rpt)
      nil
      (distinct
       (cons n (filter prime?
                       (map #(Integer. (.replaceAll (str n) (str rpt) (str %)))
                            (range 1 10))))))))

(defn prob-051 []
  (first (filter #(= 8 (count (family %))) (filter #(> % 10000) primes))))