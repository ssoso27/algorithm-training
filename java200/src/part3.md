# Part 3: 중급 - Java 프로그래밍 기초 다지기
1. [foreach](#foreach)

## <span id="foreach"> 1. foreach </span> 
- iterate(루프를 돌릴 객체)를 활용하여 index 없이 for문 구현
- iterate의 요소가 순차적으로 대입되어 for문 수행
- iterate : 배열, ArrayList 등 loop가 가능한 형태
- 값을 변경하기 보단, **출력**목적 위주로 사용
- 단점 : 반복횟수를 명시적으로 주는 것이 불가능 **(step = 1)**
- 구조
```java
for (type var : iterate) {
    body-of-loop
}
```
```java
String[] names = {"철수", "바둑이", "뒷동산"};

for (String name: names) {
    System.out.println(name);
}
```