;;;;;;;;;; problem 035 ;;;;;;;;;;
(use '[clojure.contrib.seq-utils :only (includes?)])

(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (= n 3) true
    (even? n) false
    :else (if (includes? (for [x (range 3 (+ (Math/sqrt n) 2))]
            (zero? (mod n x))) true) false true)))

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