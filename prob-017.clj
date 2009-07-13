;;;;;;;;;; problem 017 ;;;;;;;;;;
(def one-nineteen ["one", "two", "three", "four", "five", "six", "seven",
                   "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                   "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                   "nineteen"])
(def twenty-by-10s ["twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
                    "eighty", "ninety"])

(defn num-to-english
  ([n] (num-to-english n ""))
  ([n s]
   (cond (zero? n) s
     (< n 20) (str s (one-nineteen (dec n)))
     (< n 100) (recur (mod n 10)
                      (str s (twenty-by-10s (- (quot n 10) 2))))
     (< n 1000) (recur (mod n 100)
                       (str s (one-nineteen (dec (quot n 100)))
                            "hundered" (if (zero? (mod n 100))
                                         "" "and")))
     (= n 1000) "onethousand")))

(defn prob-017 []
  (reduce + (map #(count (num-to-english %)) (range 1 1001))))
