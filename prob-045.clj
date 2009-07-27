;;;;;;;;;; problem 045 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (triangles pentagonals hexagonals)])

(defn prob-045 []
  (let [ts (apply sorted-set (take 100000 triangles))
        ps (apply sorted-set (take 100000 pentagonals))]
    (second (filter #(and (ts %) (ps %)) (rest hexagonals)))))