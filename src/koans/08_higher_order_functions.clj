(ns koans.08-higher-order-functions
  (:require [koan-engine.core :refer :all]))

(meditations
  "맵(map) 함수는 시퀀스를 관련한 다른 시퀀스로 만들어낸다"
  (= [4 8 12] (map (fn [x] (* 4 x)) [1 2 3]))

  "연관 함수를 직접 만들어서 쓰거나"
  (= [1 4 9 16 25] (map (fn [x] (* x x)) [1 2 3 4 5]))

  "아니면, 이미 있는 함수의 이름을 쓸 수 있다"
  (= [false false true false false] (map nil? [:a :b nil :c :d]))

  "필터(filter)는 매우 강력하다"
  (= [] (filter (fn [x] false) '(:anything :goes :here)))

  "때로는 매우 약하다"
  (= [:anything :goes :here] (filter (fn [x] true) '(:anything :goes :here)))

  "아니면 그사이 어딘가에 있다"
  (= [10 20 30] (filter (fn [x] (<= x 30)) [10 20 30 40 50 60 70 80]))

  "맵(map)과 필터(filter)를 조합할 수도 있다"
  (= [10 20 30] (map (fn [x] (* x 10)) (filter (fn [x] (< x 4)) [1 2 3 4 5 6 7 8])))

  "리듀스(reduce)는 결과값을 누적하는데 쓸 수 있다"
  (= 24 (reduce (fn [a b] (* a b)) [1 2 3 4]))

  "초기값을 지정해 시작할 수 있다"
  (= 2400 (reduce (fn [a b] (* a b)) 100 [1 2 3 4]))

  "숫자에만 리듀스(reduce)를 쓸 수 있는 것은 아니다"
  (= "longest" (reduce (fn [a b]
                         ; (if (< (.length a) (.length b)) b a))
                         (if (< (count a) (count b)) b a))
                       ["which" "word" "is" "longest"])))
