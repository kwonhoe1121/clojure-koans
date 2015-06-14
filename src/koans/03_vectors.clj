(ns koans.03-vectors
  (:require [koan-engine.core :refer :all]))

(meditations
  ; "You can use vectors in clojure as array-like structures"
  "클로저의 벡터(vector)는 마치 배열처럼 쓸 수 있다"
  (= __ (count [42]))

  ; "You can create a vector from a list"
  "리스트를 벡터로 만들 수도 있다"
  (= __ (vec '(1)))

  ; "Or from some elements"
  "아니면 요소 몇 개로부터"
  (= __ (vector nil nil))

  ; "But you can populate it with any number of elements at once"
  "아니면 한꺼번에 여러 요소를 가져와서 만들 수도 있다"
  (= [1 __] (vec '(1 2)))

  ; "Conjoining to a vector is different than to a list"
  "벡터에 어떤 요소를 결합(conjoin)하는 것은 리스트에 결합하는 방식과 다르다"
  (= __ (conj [111 222] 333))

  ; "You can get the first element of a vector like so"
  "벡터의 첫번째 요소는 리스트에서 가져올 때와 같이 구할 수 있다"
  (= __ (first [:peanut :butter :and :jelly]))

  ; "And the last in a similar fashion"
  "비슷한 방식으로 마지막 값도 구할 수 있다"
  (= __ (last [:peanut :butter :and :jelly]))

  ; "Or any index if you wish"
  "또는, 몇 번째 요소를 원하는지 말하라"
  (= __ (nth [:peanut :butter :and :jelly] 3))

  ; "You can also slice a vector"
  "벡터를 쪼갤 수도 있다"
  (= __ (subvec [:peanut :butter :and :jelly] 1 3))

  ; "Equality with collections is in terms of values"
  "컬렉션과 비교는 각각의 값들을 비교해서 판단한다"
  (= (list 1 2 3) (vector 1 2 __)))
