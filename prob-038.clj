;;;;;;;;;; problem 037 ;;;;;;;;;;
(defn pandigital? [n]
  (= "123456789" (apply str (sort (rest (.split (str n) ""))))))

(defn concat-prod
  ([n] (concat-prod n 2 [n] (.length (str n))))
  ([n x coll len]
     (if (>= len 9)
       coll
       (let [nx (* n x)]
         (recur n (inc x) (conj coll nx) (+ len (.length (str nx))))))))
  

(defn prob-038 []
  (reduce max (for [n (range 2 10000)
                    :let [p (bigint (apply str (concat-prod n)))]
                    :when (and (pandigital? p)
                               (not (pandigital? n)))]
                p)))