;;;;;;;;;; problem 055 ;;;;;;;;;;
(defn palindrome? [n]
  (= (str n) (str (reverse-num n))))

(defn reverse-num [n]
  (bigint (str (.reverse (StringBuffer. (str n))))))

(defn reverse-add [n]
  (+ n (reverse-num n)))

(defn lychrel?
  ([n] (lychrel? n 1))
  ([n i]
     (if (> i 50)
       true
       (let [ra (reverse-add n)]
         (if (palindrome? ra)
           false
           (recur ra (inc i)))))))

(defn prob-055 []
  (count (filter lychrel? (range 1 10000))))