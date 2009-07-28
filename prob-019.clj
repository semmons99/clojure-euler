;;;;;;;;;; problem 019 ;;;;;;;;;;
(import '(java.util Calendar GregorianCalendar))

(defn sunday? [year month day]
  (= Calendar/SUNDAY
     (.get (GregorianCalendar. year (dec month) day) Calendar/DAY_OF_WEEK)))

(defn prob-019 []
  (count (for [month (range 1 13)
               year (range 1901 2001)
               :when (sunday? year month 1)]
           true)))
