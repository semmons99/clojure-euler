;;;;;;;;;; problem 045 ;;;;;;;;;;
(defn nth-triangle [n] (/ (* n (inc n)) 2))

(defn triangles [] (map nth-triangle (iterate inc 2)))

(defn nth-pentagonal [n] (/ (* n (dec (* 3 n))) 2))

(defn pentagonals [] (map nth-pentagonal (iterate inc 2)))

(defn nth-hexagonal [n] (* n (dec (* 2 n))))

(defn hexagonals [] (map nth-hexagonal (iterate inc 2)))

(defn prob-045 []
  (let [ts (apply sorted-set (take 100000 (triangles)))
        ps (apply sorted-set (take 100000 (pentagonals)))
        hs (apply sorted-set (take 100000 (hexagonals)))]
    (second (filter #(and (ps %) (hs %)) ts))))