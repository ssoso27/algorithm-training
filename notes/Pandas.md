# Pandas.md

- pandas : R의 dataframe을 모방하고 다룰 수 있도록 하는 파이썬 라이브러리
- https://wikidocs.net/4364


## Dataframe

테이블 형식의 데이터를 다룰 때 사용.

* [참고] 파이썬 기본 데이터 타입
  * list
  * tuple
  * dictionary

### 1. Pandas Dataframe 만들기

~~~python
# 2차원 배열 -> 데이터프레임
my_2darray = np.array([[1, 2, 3], [4, 5, 6]])
pd.DataFrame(my_2darray)

# Dictionary -> DataFrame
my_dict = {"a": ['1', '3'], "b": ['1', '2'], "c": ['2', '4']}
pd.DataFrame(my_dict)

# DataFrame -> DataFrame
my_df = pd.DataFrame(data=[4, 5, 6, 7], index = range(0, 4), colums=['A'])
pd.DataFrame(my_df)

# Series -> DataFrame
# Series : pandas에서 제공하는 데이터타입. index가 있는 1차원 배열. dataframe의 한 컬럼
my_series = pd.Series({"United Kingdom":"London", "India":"New Delhi", "United States":"Washington", "Belgium":"Brussels"})
pd.DataFrame(my_series)
~~~



### 2. indexing 및 조작



### 3. column, row 삭제

#### column 삭제

~~~python
df = DataFrame({
    "x1": [1, 2, 3],
    "x2": [11, 22, 33],
    "x3": [111, 222, 333],
    "x4": [12, 13, 14]}
)

# x1 열 삭제
del my_df["x1"]

# x2 열 삭제
df = df.drop("x2", 1) # axis = 1 : 세로축 삭제, 0 : 가로축 삭제

# x3, x4 열 삭제
df = df.drop(["x3", "x4"], 1)
"""
Empty DataFrame
Columns: []
Index: [0, 1, 2]
"""
~~~



#### row 삭제

~~~python
df = DataFrame({
    "x1": [1, 2, 3], 
    "x2": [11, 22, 33], 
    "x3": [111, 222, 333]}
)
"""
   x1  x2   x3  x4
0   1  11  111  12
1   2  22  222  13
2   3  33  333  14
"""

# 1번 행 삭제
df = df.drop(1, 0) # axis = 0 -> 가로축 삭제
"""
   x1  x2   x3
0   1  11  111
2   3  33  333
"""

# 0, 2 번째 행 삭제
df = df.drop([0, 2], 0)
"""
Empty DataFrame
Columns: [x1, x2, x3]
Index: []
"""
~~~



## Series

### 기초

- 1차원 배열과 같은 자료구조

~~~python
from pandas import Series, DataFrame

kakao = Series([92600, 92400, 92100, 94300, 92300])
print(kakao)
~~~

결과

~~~python
0    92600 # 따로 인덱스 미지정 -> 0부터 시작
1    92400
2    92100
3    94300
4    92300
dtype: int64
~~~

- Series 객체는 값뿐만 아니라, 연결된 index 값도 동시에 저장함

- 정수 인덱스 값을 통해 접근 가능

- ~~~python
  print(kakao[0]) # 92600
  print(kakao[2]) # 92100
  print(kakao[4]) # 92300
  ~~~

- 파이썬 리스트와 달리, **index 값 지정 가능**

- ~~~python
  kakao2 = Series([92600, 92400, 92100, 94300, 92300], index=['2016-02-19',
  '2016-02-18',
  '2016-02-17',
  '2016-02-16',
  '2016-02-15'])
  
  /*
  # index 	value
  2016-02-19    92600 
  2016-02-18    92400
  2016-02-17    92100
  2016-02-16    94300
  2016-02-15    92300
  dtype: int64
  */
  
  print(kakao2['2016-02-19']) # 92600
  ~~~

- Series 객체의 index, values 속성으로 접근 가능

- ~~~python
  for date in kakao2.index:
      print(date)
  
  for ending_price in kakao2.values:
      print(ending_price)
      
  /*
  2016-02-19
  2016-02-18
  2016-02-17
  2016-02-16
  2016-02-15
  92600
  92400
  92100
  94300
  92300
  */
  ~~~

- Series 객체의 덧셈

- ~~~python
  from pandas import Series, DataFrame
  
  # 서로 다른 인덱싱
  mine   = Series([10, 20, 30], index=['naver', 'sk', 'kt'])
  friend = Series([10, 30, 20], index=['kt', 'naver', 'sk'])
  
  # 덧셈
  merge = mine + friend
  print(merge)
  
  /*
  # 서로 다른 인덱싱이어도 성공적으로 취합
  kt       40
  naver    40
  sk       40
  dtype: int64
  */
  ~~~

- 



## Kaggle Learn 예제

### 예제 1

Q) Create a DataFrame that looks like this:

![img](https://i.imgur.com/Ax3pp2A.png)

A)

~~~python
# Your code here
my_dict = {"Apples": [30], "Bananas": [21]}
df = pd.DataFrame(my_dict)
print(check_q1(df))
~~~



### 예제2

Q) Create the following DataFrame:

![img](https://i.imgur.com/CHPn7ZF.png)

A)

~~~python
df2 = pd.DataFrame(data = [[35, 21], [41, 34]], 
                   columns = ["Apples", "Bananas"], 
                   index = ["2017 Sales", "2018 Sales"])
# print(df2)
print(check_q2(df2))
~~~



### 예제 3

Q) **Exercise 3**: Create a `Series` that looks like this:

~~~
Flour     4 cups
Milk       1 cup
Eggs     2 large
Spam       1 can
Name: Dinner, dtype: object
~~~

A)

~~~python
# Your code here
my_si = pd.Series(
    ["4 cups", "1 cup", "2 large", "1 can"],
    index = ["Flour", "Milk", "Eggs", "Spam"]
)
# print(my_si)
print(check_q3(my_si))
~~~



### 예제 4

Q) **Exercise 4**: Read the following `csv` dataset on wine reviews into the a `DataFrame`:

![img](https://i.imgur.com/74RCZtU.png)

The filepath to the CSV file is `../input/wine-reviews/winemag-data_first150k.csv`.

A)

~~~python
# Your code here 
input = pd.read_csv("../input/wine-reviews/winemag-data_first150k.csv")
# input.head()
df4 = input.drop("Unnamed: 0", 1)
# df4.head()
print(check_q4(df4))
~~~



### 예제 6

Q) **Exercise 6**: Suppose we have the following `DataFrame`:

> ~~~python
> q6_df = pd.DataFrame({'Cows': [12, 20], 'Goats': [22, 19]}, index=['Year 1', 'Year 2'])
> ~~~

Save this `DataFrame` to disc as a `csv` file with the name `cows_and_goats.csv`.

A)

~~~python
# Your code here
q6_df.to_csv("cows_and_goats.csv", mode='w')
~~~



### 예제 7

**Exercise 7**: This exercise is optional. Read the following `SQL` data into a `DataFrame`:

![](https://i.imgur.com/mmvbOT3.png)

The filepath is `../input/pitchfork-data/database.sqlite`. Hint: use the `sqlite3` library. The name of the table is `artists`.

A)

~~~

~~~

