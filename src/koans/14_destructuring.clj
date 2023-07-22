(ns koans.14-destructuring
  (:require [koan-engine.core :refer :all]))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations
  "디스트럭쳐링(destructuring)으로 전달인자를 나눌 수 있다"
  (= (str :bar :foo) ((fn [[a b]] (str b a))
         [:foo :bar]))

  "함수 정의에서도 쓸 수 있고"
  (= (str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")
     ((fn [[a b c]] (str "First comes " a ", then comes " b ", then comes " c " with the baby carriage"))
      ["love" "marriage" "Clojure"]))

  "또는 let 표현식에서도 쓴다"
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
     (let [[first-name last-name & aliases]
           (list "Rich" "Hickey" "The Clojurer" "Go Time" "Macro Killah")]
       (str first-name " " last-name " aka " (nth aliases 0) " aka " (nth aliases 1) " aka " (nth aliases 2))))

  "전체 전달인자를 되찾을 수 있다"
  (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
     (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
       {:original-parts full-name :named-parts {:first first-name :last last-name}}))

  "맵(map)을 키(key)로 나눠 받을 수 있다"
  (= "123 Test Lane, Testerville, TX"
     (let [{street-address :street-address, city :city, state :state} test-address]
       (str street-address ", " city ", " state)))

  "아니면 더 간명하게도"
  (= "123 Test Lane, Testerville, TX"
     (let [{:keys [street-address city state]} test-address]
       (str street-address ", " city ", " state)))

  "전부 다 써보자!"
  (= "Test Testerson, 123 Test Lane, Testerville, TX"
     ((fn [[a b] {:keys [street-address city state]}]
        (str a " " b ", " street-address ", " city ", " state)) ["Test" "Testerson"] test-address)))
