(ns koans.05-maps
  (:require [koan-engine.core :refer :all]))

(meditations
  "맵(map)을 만들때 길을 잃지 마라"
  (= {:a 1 :b 2} (hash-map :a 1 :b 2))

  "모든 키(key)에 대응하는 값이 반드시 있어야 한다"
  (= {:a 1} (hash-map :a 1))

  "그 크기는 엔트리(entry)의 수이다"
  (= 2 (count {:a 1 :b 2}))

  "키로 그 값을 찾을 수 있다"
  (= 2 (get {:a 1 :b 2} :b))

  "맵을 함수처럼 써서 값을 찾을 수 있다"
  (= 1 ({:a 1 :b 2} :a))

  "키워드도 마찬가지다"
  (= 1 (:a {:a 1 :b 2}))

  "맵의 키가 반드시 키워드일 필요는 없다"
  (= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

  "때로는 키로 엔트리를 찾지 못할 때도 있다"
  (= nil (get {:a 1 :b 2} :c))

  "그러나, 기본값을 준비할 수 있다"
  (= :key-not-found (get {:a 1 :b 2} :c :key-not-found))

  "특정 키가 있는지 확인할 수 있다"
  (= true (contains? {:a nil :b nil} :b))

  "아니면 없는지도."
  (= false (contains? {:a nil :b nil} :c))

  "맵은 불변(immutable)이지만, 엔트리를 추가한 새 버전을 만들 수 있다"
  (= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February"))

  "한 엔트리를 제거한 새 버전을 만들 수도 있다"
  (= {1 "January"} (dissoc {1 "January" 2 "February"} 2))

  "키목록이 필요하면 구할 수 있지만, 순서는 보장되지 않는다"
  (= (list 2010 2014 2018)
     (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

  "값들도 비슷한 방법으로 구할 수 있다"
  (= (list "PyeongChang" "Sochi" "Vancouver")
     (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"}))))
