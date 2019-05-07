'''
[다음 입사문제 중에서]
- http://codingdojang.com/scode/408?answer_mode=hide

1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오. (단, 점들의 배열은 모두 정렬되어 있다고 가정한다.)

예를 들어, S = {1, 3, 4, 8, 13, 17, 20} 이 주어졌다면, 결과값은 (3, 4)가 될 것이다.

'''
import random

dots = sorted([random.randrange(1, 100) for i in range(random.randrange(3, 10))])
# dots = [1, 3, 4, 8, 13, 17, 20]
min = 9223372036854775807
results = []
for i in range(2, len(dots)):
    if dots[i] - dots[i-1] < min:
        min = dots[i] - dots[i-1]
        results.clear()
        results.append((dots[i-1], dots[i]))
    elif dots[i] - dots[i-1] == min:
        results.append((dots[i-1], dots[i]))

print(dots)
print(results)
print(min)