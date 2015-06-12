(ns koans.08-higher-order-functions
  (:require [koan-engine.core :refer :all]))

(meditations
  ;; "The map function relates a sequence to another"
  "맵(map) 함수는 시퀀스를 연관된 다른 시퀀스로 만들어낸다"
  (= [__ __ __] (map (fn [x] (* 4 x)) [1 2 3]))

  ;; "You may create that mapping"
  "그 연관을 함수로 만들어 내거나"
  (= [1 4 9 16 25] (map (fn [x] __) [1 2 3 4 5]))

  ;; "Or use the names of existing functions"
  "아니면, 이미 있는 함수의 이름을 쓸 수 있다"
  (= __ (map nil? [:a :b nil :c :d]))

  ;; "A filter can be strong"
  "필터(filter)는 매우 강력하다"
  (= __ (filter (fn [x] false) '(:anything :goes :here)))

  ;; "Or very weak"
  "때로는 매우 약하다"
  (= __ (filter (fn [x] true) '(:anything :goes :here)))

  ;; "Or somewhere in between"
  "아니면 그사이 어딘가에 있다"
  (= [10 20 30] (filter (fn [x] __) [10 20 30 40 50 60 70 80]))

  ;; "Maps and filters may be combined"
  "맵(map)과 필터(filter)를 조합할 수도 있다"
  (= [10 20 30] (map (fn [x] __) (filter (fn [x] __) [1 2 3 4 5 6 7 8])))

  ;; "Reducing can increase the result"
  "리듀스(reduce)는 결과값을 누적하는데 쓸 수 있다"
  (= __ (reduce (fn [a b] (* a b)) [1 2 3 4]))

  ;; "You can start somewhere else"
  "초기값을 지정할 수도 있다"
  (= 2400 (reduce (fn [a b] (* a b)) __ [1 2 3 4]))

  ;;"Numbers are not the only things one can reduce"
  "숫자에만 리듀스(reduce)를 쓸 수 있는 것은 아다"
  (= "longest" (reduce (fn [a b]
                         (if (< __ __) b a))
                       ["which" "word" "is" "longest"])))
