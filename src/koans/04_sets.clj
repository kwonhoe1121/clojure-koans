(ns koans.04-sets
  (:require [koan-engine.core :refer :all]))

(meditations
  ; "You can create a set by converting another collection"
  "컬렉션을 변환해서 집합을 만들 수 있다"
  (= #{3} (set __))

  ; "Counting them is like counting other collections"
  "갯수는 컬렉션과 같은 방법으로 구한다"
  (= __ (count #{1 2 3}))

  ; "Remember that a set is a *mathematical* set"
  "집합은 *수학에서의* 집합임을 기억하라"
  (= __ (set '(1 1 2 2 3 3 4 4 5 5)))

  ; "You can ask clojure for the union of two sets"
  "클로저에게 합집합을 구해달라고 할 수 있다"
  (= __ (clojure.set/union #{1 2 3 4} #{2 3 5}))

  ; "And also the intersection"
  "교집합도 마찬가지다"
  (= __ (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

  ; "But don't forget about the difference"
  "차집합에 대해서도 잊지 마라"
  (= __ (clojure.set/difference #{1 2 3 4 5} #{2 3 5})))
