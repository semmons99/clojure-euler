;;;;;;;;;; problem 004 ;;;;;;;;;;
(defn palindrome? [n]
  (= (str n) (str (.reverse (StringBuffer. (str n))))))

(defn prob-004 []
  (let [nums (range 100 1000)]
    (reduce max (for [x nums
                      y nums
                      :when (palindrome? (* x y))]
                  (* x y)))))
