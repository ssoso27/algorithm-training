# Part 3: 중급 - Java 프로그래밍 기초 다지기
1. [foreach](#foreach)
2. [varargs(가변인자)](#varargs)
3. [List](#list)
4. [Lambda 형식](#lambda)

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

## <span id="varargs">2. varargs (가변인자)</span>
- 필요에 따라 매개변수의 개수를 가변적으로 조정할 수 있는 기술
- 매개변수 : <u>동일 type의 한 개 이상의 변수 or 배열</u>
- 매개변수 개수 별로 여러 개가 필요했던 메소드를 하나로 처리  
    ->**오버로딩 메서드 개수가 줄어듬**
- String... 와 같은 type의 매개변수를 받음 -> 컴파일러가 **배열**로 변환
- (이전) 컬렉션을 이용한 가변인자
~~~java
void method(Vector v) {
    for (Object s : v) {
        System.out.println(s);
    }
}
  
// 호출
Vector vec = new Vector();
vec.add("a");
vec.add("b");
vec.add("c");
  
method(vec)
~~~
- (현재) 가변인자를 사용한 메소드
~~~java
void method(String... strs) {
    for (String s: strs) {
        System.out.println(s);
    }
}
  
// 호출
method("a", "b", "c");
~~~

## 3. <span id="list">List</span>
- 배열과 비슷한 자료형이나, 더 많은 기능을 제공
- 크기가 정해져 있지 않고 <u>저장공간을 스스로 확보</u>하면서 데이터 저장
- 종류 : ArrayList, LinkedList 

|      	| ArrayList                                                  	| LinkedList                                    	| Vector                                                 	|
|------	|------------------------------------------------------------	|-----------------------------------------------	|--------------------------------------------------------	|
| 설명 	| 배열로 구현한 리스트                                       	| 각 노드는 이전/다음 노드의 상태만 알고 있음   	| (서로 다른) 객체에 대한 참조값을 저장하는 배열         	|
|      	| index를 사용해 배열에 접근                                 	| 데이터 검색 시, 처음부터 노드 순회 필요       	| 길이 가변 가능 (부족한 저장공간 늘리는 갯수 지정 가능) 	|
|      	| 배열 초기 길이 지정 필요 + 동적 변경 어려움                	|                                               	| 다양한 객체를 하나의 Vector에 저장 가능                	|
|      	| 데이터 추가/삭제 시, 임시 배열에 복사하는 방법 사용        	|                                               	| 다수의 스레드에 동기화 O                               	|
|      	| 다수의 스레드에 동기화 x                                   	|                                               	| 기본형 데이터 저장 불가 (-> Wrapper 클래스 사용 필요)  	|
| 탐색 	| Iterator 사용                                              	|                                               	|                                                        	|
| 빠름 	| 조회 (메모리 주소로 직접 참조) - O(1)                      	| 추가/삭제                                     	|                                                        	|
| 느림 	| 추가/삭제 (새로운 데이터 추가 시, 길이 2배의 새 배열 만듬) 	| 조회 - O(n)                                   	|                                                        	|

- 내장함수
    1. add(value)
    2. get(index)
    3. size()
    4. contains(value)
    5. remove(index 혹은 value)
    ```java
        List<String> list = new ArrayList<>();
        list.add("철수");
        list.add("바둑이");
        list.add("고구마");
         
        System.out.println(list.get(2)); // "고구마" 출력
        System.out.println(list.size()); // 3 출력
        System.out.println(list.contains("영희")); // false 출력
        System.out.println(list.remove(1)); // "바둑이" 삭제 후 "바둑이" 출력
        System.out.println(list.remove("철수")); // true 출
    ```
=======
    
## 4. Lambda 형식
- 기본 구조  
    ```java
    (타입 매개변수, ... ) -> { 실행문 }  
    ex) (int a) -> { System.out.println(a); }
    ```
- 타입, ( ), { }, return은 생략 가능하다
 > - 타입 : 런타임 시 대입되는 값에 따라 자동 인식 됨
 > - ( ) : 매개변수가 1개 뿐일 때 생략 가능
 > - { } : 실행문이 한 줄 뿐일 때 생략 가능
 > - return : return문만 있을 때 생략 가능
- Java는 메소드만 단독 생성이 불가하고, 오직 클래스의 멤버함수 형태로만 존재한다.  
    => 따라서, 람다식은 **해당 메소드를 지닌 객체**를 생성한다.  
        이 때, 객체는 interface의 **익명 구현 객체**이다.
- target type : 구현 대상 interface
- target type은 <u>추상 메소드가 1개 뿐인</u> interface만 가능하다.
- **@FunctionalInterface** : 두 개 이상의 추상메소드를 막는 어노테이션
- 각 유형 별 람다식
    1. 매개변수와 리턴값이 없는 람다식
    ```java
    interface MyInterface {
      public void method();  
    }
      
    ...
      
   MyInterface fi = () -> { System.out.println("method"); };

    ```
    2. 매개변수가 있는 람다식
    ```java
    interface MyInterface {
      public void method(int x);  
    }
      
    ...
      
   MyInterface fi = (x) -> { System.out.println(x); };
   MyInterface f1 = x -> System.out.println(x + 1); 
 
   fi.method(3); // 가장 마지막으로 구현된 x + 1 수행

    ```
    3. 리턴값이 있는 람다식
    ```java
    interface MyInterface {
      public void method(int x, int y);  
    }
      
    ...
      
   MyInterface fi = (x, y) -> { return sum(x+y); };
   MyInterface fi = (x, y) -> sum(x+y);

    ```
