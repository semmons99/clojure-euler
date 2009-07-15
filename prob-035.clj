;;;;;;;;;; problem 035 ;;;;;;;;;;
(defn prime? [n]
  (cond
    (< n 2) false
    (< n 4) true
    (even? n) false
    :else (let [lim (inc (Math/sqrt n))]
            (loop [x 3]
              (cond
                (> x lim) true
                (zero? (mod n x)) false
                :else (recur (inc x)))))))

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