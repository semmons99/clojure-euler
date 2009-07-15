;;;;;;;;;; problem 039 ;;;;;;;;;;
(defn right-triangles [p]
  (distinct (for [a (range 1 (dec p))
                  b (range 1 (- p a 1))
                  :let [c (- p a b)]
                  :when (= (+ (* a a) (* b b)) (* c c))]
              #{a b c})))

(defn max-triangles [a b]
  (if (> (last a) (last b)) a b))

(defn prob-039 []
  (reduce max-triangles (for [p (range 1 1001)]
                          [p (count (right-triangles p))])))