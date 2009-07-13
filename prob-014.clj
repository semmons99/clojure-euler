;;;;;;;;;; problem 014 ;;;;;;;;;;
(defn next-seq [n]
  (if (even? n)
    (/ n 2)
    (+ (* 3 n) 1)))

(defn gen-seq
  ([n] (gen-seq n []))
  ([n chain]
   (if (= n 1)
     (lazy-seq (cons n chain))
     (recur (next-seq n) (lazy-seq (cons n chain))))))

(defn max-chain [a b] (if (> (last a) (last b)) a b))

(defn prob-014 []
  (reduce max-chain (map #(cons % [(count (gen-seq %))]) (range 1 1000000))))
