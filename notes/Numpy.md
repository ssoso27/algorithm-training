# Numpy.md

- 과학 계산을 위한 라이브러리.
- 다차원 배열을 처리하는데 필요한 여러 유용한 기능을 제공함.

## Numpy 배열

- 동일한 타입의 값들을 지님

- 배열의 차원 : rank

- 각 차원의 크기 튜플 : shape

  ~~~
  ex) 행이 2이고, 열이 3인 2차원 배열
  rank : 2
  shape : (2, 3)
  ~~~

### numpy 배열 만들기

1. python list 이용하기

   ~~~python
   import numpy as np
    
   list1 = [1, 2, 3, 4]
   a = np.array(list1)
   print(a.rank) # 1
   print(a.shape) # (4, )
    
   # np.array() 에는 하나의 리스트만 들어가므로, 중첩리스트를 넣어야 한다.
   b = np.array([[1,2,3],[4,5,6]])
   print(b.shape) # (2, 3)
   print(b[0,0])  # 1    
   ~~~


2. 

