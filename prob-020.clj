;;;;;;;;;; problem 020 ;;;;;;;;;;
(defn prob-020 []
  (reduce + (map #(Integer. %)
                 (rest (.split (str (reduce * (range 1 101))) "")))))
