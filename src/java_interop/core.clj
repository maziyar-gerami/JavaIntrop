(ns java-interop.core
  (:gen-class)
  (:import java.awt.Point))
;; Static field : Math.PI;
(Math/PI)
;; Static function : Math.abs(- 2);
(Math/abs -2)
;; Static function : Math.sqrt(4);
(Math/sqrt 4)
;; create new object : new Point (2 , 3);
(.toString (new Point 2 3))
;; create new object : new Point (2 , 3)
;; then get x from it;
(.getX (new Point 5 3))
;; create new object : new Point ()
;; then get y from it;
(.getY (new Point 2 5))
(.-y (new Point 2 5))
;; static function : java.time.LocalDate.now()
(java.time.LocalDate/now)
;; static function : java.time.Period.ofWeeks(2);
(java.time.Period/ofWeeks 2)

(.plus (java.time.LocalDate/now)
       (java.time.Period/ofWeeks 2))

(.plus (java.time.LocalDate/now)
       (java.time.Period/ofYears 209))
;; new String ("maziyar")

(new String "maziyar")

;; new String ("maziyar").toUpperCase()

(.toUpperCase (new String "maziyar"))

(->
 (new String "maziyar")
 .toUpperCase
 (.charAt 3))


(.. String

    " mazyar"

    .toUpperCase)

(defn local-datetime-to-utc [local-datetime]
  (let [instant (.toInstant local-datetime (java.time.ZoneOffset/UTC))]
    (.atOffset instant (java.time.ZoneOffset/UTC))
    (-> instant (.atOffset (java.time.ZoneOffset/UTC)) .toLocalDateTime)))

(def local-datetime (java.time.LocalDateTime/now))
(def utc-datetime (local-datetime-to-utc local-datetime))

(println "Original LocalDateTime:" local-datetime)
(println "UTC LocalDateTime:" utc-datetime)