(ns koans.04-sets
  (:require [koan-engine.core :refer :all]))

(meditations
  "컬렉션을 변환해서 집합을 만들 수 있다"
  (= #{3} (set '(3)))

  "갯수는 컬렉션과 같은 방법으로 구한다"
  (= 3 (count #{1 2 3}))

  "집합은 *수학에서의* 집합임을 기억하라"
  (= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5)))

  "클로저에게 합집합을 구해달라고 할 수 있다"
  (= #{1 2 3 4 5} (clojure.set/union #{1 2 3 4} #{2 3 5}))

  "교집합도 마찬가지다"
  (= #{2 3} (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

  "차집합에 대해서도 잊지 마라"
  (= #{1 4} (clojure.set/difference #{1 2 3 4 5} #{2 3 5})))
