;;;;;;;;;; problem 036 ;;;;;;;;;;
(defn palindrome? [n]
  (= (str n) (str (.reverse (StringBuffer. (str n))))))

(defn prob-036 []
  (reduce + (for [n (range 1 1000000)
                  :when (and (palindrome? n)
                             (palindrome? (Integer/toBinaryString n)))]
              n)))