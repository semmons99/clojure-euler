;;;;;;;;;; problem 097 ;;;;;;;;;;
(defn prob-097 []
  (let [n (inc (* 28433
                  (. (bigint 2)
                     (modPow (bigint 7830457) (bigint 10000000000)))))
        s (str n)]
    (subs s (- (count s) 10))))