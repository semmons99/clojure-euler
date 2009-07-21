;;;;;;;;;; problem 057 ;;;;;;;;;;
(defn numerator [r]
  (bigint (first (.split (str r) "/"))))

(defn denominator [r]
  (bigint (last (.split (str r) "/"))))

(defn num-digits [n]
  (count (rest (.split (str n) ""))))

(defn more-digits [r]
  (let [nd (num-digits (numerator r))
        dd (num-digits (denominator r))]
    (cond
      (> nd dd) :numerator
      (< nd dd) :denominator
      :else :same)))

(defn next-expansion [pex]
  (/ (denominator pex) (+ (* 2 (denominator pex)) (numerator pex))))

(defn prob-057 []
  (count
   (filter #(= :numerator %)
           (map more-digits (take 1000 (map inc (iterate next-expansion (/ 1 2))))))))