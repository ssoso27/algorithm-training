'''
[Multiples of 3 and 5]
- http://codingdojang.com/scode/350?answer_mode=hide

10미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다. 이들의 총합은 23이다.

1000미만의 자연수에서 3,5의 배수의 총합을 구하라.
'''

def solution():
    sum = 0
    for i in range(1, 1000):
        if i % 3 == 0:
            sum += i
        elif i % 5 == 0:
            sum += i
    print(sum)

solution()

# 다른 사람 풀이
print(sum([i for i in range(1000) if i % 3 == 0 or i % 5 == 0]))

set3 = set(range(3, 1000, 3))
set5 = set(range(5, 1000, 5))
print( sum(set3 | set5) ) # set3과 set5의 합집합의 합