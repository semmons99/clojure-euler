;;;;;;;;;; problem 031 ;;;;;;;;;;
(defn make-change
  ([amt] (make-change amt [1 2 5 10 20 50 100 200]))
  ([amt coins]
   (cond
     (or (empty? coins) (< amt 0)) 0
     (= 1 (count coins)) 1
     :else (+ (make-change amt (butlast coins))
              (make-change (- amt (last coins)) coins)))))

(defn prob-031 []
  (make-change 200))
