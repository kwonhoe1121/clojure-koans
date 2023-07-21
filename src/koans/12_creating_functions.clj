(ns koans.12-creating-functions
  (:require [koan-engine.core :refer :all]))

(defn square [x] (* x x))

(meditations
  "찾지 않는 것을 아는 방법으로 찾는 것을 알게 되기도 한다"
  (= [true false true] (let [not-a-symbol? (complement symbol?)]
                  (map not-a-symbol? [:a 'b "c"])))

  "'complement'로 밀의 겨를 벗겨낼 수 있다"
  (= [:wheat "wheat" 'wheat]
       (let [not-nil? (complement nil?)]
         (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil])))

  "부분(partial) 함수로 늑장 부릴 수 있다"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (multiply-by-5 4)))

  "명심하라: 처음 것이 먼저다"
  (= [:a :b :c :d]
       (let [ab-adder (partial concat [:a :b])]
         (ab-adder [:c :d])))

  "여러 함수를 하나의 합성(composed) 함수로 합칠 수 있다"
  (= 25 (let [inc-and-square (comp square inc)]
          (inc-and-square 4)))

  "이중 차감함수를 만들어 보라"
  (= 8 (let [double-dec (comp dec dec)]
          (double-dec 10)))

  "함수를 합치는 순서에 유의하라"
  (= 99 (let [square-and-dec (comp dec square)]
          (square-and-dec 10))))
