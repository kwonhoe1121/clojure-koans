(ns koans.10-lazy-sequences
  (:require [koan-engine.core :refer :all]))

(meditations
  ;; "There are many ways to generate a sequence"
  "시퀀스를 만드는 방법은 여러 가지다"
  (= __ (range 1 5))

  ;; "The range starts at the beginning by default"
  "범위는 기본적으로 0에서 시작한다"
  (= __ (range 5))

  ;; "Only take what you need when the sequence is large"
  "시퀀스가 클 때는 필요한 만큼만 가져오라"
  (= [0 1 2 3 4 5 6 7 8 9]
     (take __ (range 100)))

  ;; "Or limit results by dropping what you don't need"
  "아니면, 필요 없는 만큼을 버리고 쓰라"
  (= [95 96 97 98 99]
     (drop __ (range 100)))

  ;; "Iteration provides an infinite lazy sequence"
  "iterate로 무한 지연(lazy) 시퀀스를 만들 수 있다"
  (= __ (take 20 (iterate inc 0)))

  ;; "Repetition is key"
  "반복이 핵심이다"
  (= [:a :a :a :a :a :a :a :a :a :a ]
     (repeat 10 __))

  ;; "Iteration can be used for repetition"
  "반복하기 위해 iterate를 쓸 수 있다"
  (= (repeat 100 :foo)
     (take 100 (iterate ___ :foo))))
