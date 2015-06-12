(ns koans.07-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :fade-out          :you-and-what-army
        :double-take       :call-me-when-its-important
        :round-house       :o-rly
        :fast-pace         :thats-pretty-bad
        :cocked-pistol     :sirens
        :say-what?))

(meditations
  ; "You will face many decisions"
  "결정해야만 하는 일들이 많은 것이다"
  (= __ (if (false? (= 4 5))
          :a
          :b))

  ; "Some of them leave you no alternative"
  "어떤 결정은 대안이 없다"
  (= __ (if (> 4 3)
          []))

  ; "And in such a situation you may have nothing"
  "그리고 그런 경우에는 아무 것도 남지 않기도 한다"
  (= __ (if (nil? 0)
          [:a :b :c]))

  ; "In others your alternative may be interesting"
  "때로는 대안이 흥미로울 수 있다"
  (= :glory (if (not (empty? ()))
              :doom
              __))

  ; "You may have a multitude of possible paths"
  "그대에게는 매우 다양한 길이 있다"
  (let [x 5]
    (= :your-road (cond (= x __) :road-not-taken
                        (= x __) :another-road-not-taken
                        :else __)))

  ; "Or your fate may be sealed"
  "아니, 그대의 운명은 이미 정해진 걸지도"
  (= 'doom (if-not (zero? __)
          'doom
          'more-doom))

  ; In case of emergency, sound the alarms
  "비상시에는 알람을 울려라"
  (= :sirens
     (explain-defcon-level __))

  ; "But admit it when you don't know what to do"
  "그러나 무얼해야할지 모르겠다면 그 사실을 인정하라"
  (= __
     (explain-defcon-level :yo-mama)))
