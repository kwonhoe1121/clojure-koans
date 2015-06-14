(ns koans.01-equalities
  (:require [koan-engine.core :refer :all]))

(meditations
  ; "We shall contemplate truth by testing reality, via equality"
  "같은지 확인해가며 현실을 시험해서 진실을 주의깊게 관찰하라"
  (= __ true)

  ; "To understand reality, we must compare our expectations against reality"
  "현실을 이해하기 위해서는, 반드시 우리의 예상을 현실과 비교해야만 한다"
  (= __ (+ 1 1))

  ; "You can test equality of many things"
  "여러 것이 같은지 한번에 확인할 수도 있다"
  (= (+ 3 4) 7 (+ 2 __))

  ; "Some things may appear different, but be the same"
  "어떤 것들은 겉으로는 다르게 보일지도 모르지만, 사실은 같은 것이다"
  (= __ (= 2 2/1))

  ; "You cannot generally float to heavens of integers"
  "실수와 정수는 다르다"
  (= __ (= 2 2.0))

  ; "But a looser equality is also possible"
  "그러나 관대하게 보자면 같게도 볼 수 있다"
  (= __ (== 2.0 2))

  ; "Something is not equal to nothing"
  "어떤 것이 '있다'는 '없다'의 반대다"
  (= __ (not (= 1 nil)))

  ; "Strings, and keywords, and symbols: oh my!"
  "문자열, 키워드, 그리고 심볼: 오 이런!"
  (= __ (= "foo" :foo 'foo))

  ; "Make a keyword with your keyboard"
  "키보드를 눌러 키워드를 만들어 보라"
  (= :foo (keyword __))

  ; "Symbolism is all around us"
  "심볼은 우리 주변 어디에나 있다"
  (= 'foo (symbol __))

  ; "When things cannot be equal, they must be different"
  "어떤 것들이 같을 수 없다면, 그들은 다른 것임에 틀림없다"
  (not= :fill-in-the-blank __))
