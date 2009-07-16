;;;;;;;;;; problem 035 ;;;;;;;;;;
(use '[clojure.contrib.seq-utils :only (includes?)]
     '[clojure.euler.helpers :only (prime?)])

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
  (count (filter #(and (prime? %) (circular-prime? %)) (range 1 1000000))))
