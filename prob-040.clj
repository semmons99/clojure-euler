;;;;;;;;;; problem 040 ;;;;;;;;;;
(defn prob-040 []
  (let [s (apply str (range 1 1000000))]
    (* (Integer. (subs s 0 1))
       (Integer. (subs s 99 100))
       (Integer. (subs s 999 1000))
       (Integer. (subs s 9999 10000))
       (Integer. (subs s 99999 100000))
       (Integer. (subs s 999999 1000000)))))