;;;;;;;;;; problem 033 ;;;;;;;;;;
(defn non-trivial []
  (for [a (range 10 100)
        b (range a 100)
        :let [ab (/ a b)
              a1 (Integer. (second (.split (str a) "")))
              a2 (Integer. (last   (.split (str a) "")))
              b1 (Integer. (second (.split (str b) "")))
              b2 (Integer. (last   (.split (str b) "")))]
        :when (and (not= a b)
                   (not= 0 b2)
                   (or (and (= a2 b2) (= ab (/ a1 b1)))
                       (and (= a2 b1) (= ab (/ a1 b2)))
                       (and (= a1 b1) (= ab (/ a2 b2)))
                       (and (= a1 b2) (= ab (/ a2 b1)))))]
    (/ a b)))

(defn prob-033 []
  (reduce * (non-trivial)))
