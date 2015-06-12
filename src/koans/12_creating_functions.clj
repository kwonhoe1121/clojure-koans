(ns koans.12-creating-functions
  (:require [koan-engine.core :refer :all]))

(defn square [x] (* x x))

(meditations
  ;; "One may know what they seek by knowing what they do not seek"
  "찾지 않는 것을 앎으로써 찾는 것을 알게 될 수 있다"
  (= [__ __ __] (let [not-a-symbol? (complement symbol?)]
                  (map not-a-symbol? [:a 'b "c"])))

  ;; "Praise and 'complement' may help you separate the wheat from the chaff"
  "'complement'로 밀의 겨를 벗겨낼 수 있다"
  (= [:wheat "wheat" 'wheat]
       (let [not-nil? ___]
         (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil])))

  ;; "Partial functions allow procrastination"
  "부분(partial) 함수로 늑장 부릴 수 있다"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (___ __)))

  ;; "Don't forget: first things first"
  "명심하라: 처음 것이 먼저다"
  (= [__ __ __ __]
       (let [ab-adder (partial concat [:a :b])]
         (ab-adder [__ __])))

  ;; "Functions can join forces as one 'composed' function"
  "여러 함수를 하나의 합성(composed) 함수로 합칠 수 있다"
  (= 25 (let [inc-and-square (comp square inc)]
          (inc-and-square __)))

  ;; "Have a go on a double dec-er"
  "이중 차감함수를 만들어 보라"
  (= __ (let [double-dec (comp dec dec)]
          (double-dec 10)))

  ;; "Be careful about the order in which you mix your functions"
  "함수를 합치는 순서에 유의하라"
  (= 99 (let [square-and-dec ___]
          (square-and-dec 10))))
