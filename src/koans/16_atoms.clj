(ns koans.16-atoms
  (:require [koan-engine.core :refer :all]))

(def atomic-clock (atom 0))

(meditations
  "atom은 ref와 비슷하다"
  (= 0 @atomic-clock)

  "swap!으로 바꿀 수 있다"
  (= 1 (do
          (swap! atomic-clock inc)
          @atomic-clock))

  "swap!은 트랜잭션이 필요 없다"
  (= 5 (do
         (swap! atomic-clock (fn [_] 5))
         @atomic-clock))

  "swap!의 함수에 전달인자를 여러개 줄 수 있다"
  (= 20 (do
          (swap! atomic-clock + 1 2 3 4 5)
          @atomic-clock))

  "atom은 원자적(atomic)이다"
  (= 20 (do
          (compare-and-set! atomic-clock 100 :fin)
          @atomic-clock))

  "너의 기대가 현실과 잘 어울어지면, 그대로 이뤄진다"
  (= :fin (do
            (compare-and-set! atomic-clock 20 :fin)
            @atomic-clock)))
