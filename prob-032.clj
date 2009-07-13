;;;;;;;;;; problem 032 ;;;;;;;;;;
(defn pandigital? [a b c]
  (= "123456789" (apply str (sort (rest (.split (str a b c) ""))))))

(defn prob-032 []
  (reduce + (distinct (for [a (range 2 5000)
                            b (range a (/ 9999 a))
                            :let [c (* a b)]
                            :when (pandigital? a b c)]
                        c))))
