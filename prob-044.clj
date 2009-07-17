;;;;;;;;;; problem 044 ;;;;;;;;;;
(defn nth-pentagonal [n] (/ (* n (dec (* 3 n))) 2))

(defn pentagonals [] (map nth-pentagonal (iterate inc 1)))

(defn prob-044 []
  (let [ps (apply sorted-set (take 5000 (pentagonals)))]
    (first (for [k ps
                 j (take-while #(< % k) ps)
                 :when (and (ps (- k j))
                            (ps (+ j k)))]
             (- k j)))))