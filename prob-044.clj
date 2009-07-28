;;;;;;;;;; problem 044 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (pentagonals)])

(defn prob-044 []
  (let [ps (apply sorted-set (take 5000 (pentagonals)))]
    (first (for [k ps
                 j (take-while #(< % k) ps)
                 :when (and (ps (- k j))
                            (ps (+ j k)))]
             (- k j)))))
