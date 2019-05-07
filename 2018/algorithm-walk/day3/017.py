'''
3일차(7) - 넥슨 입사문제

어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.

예를 들어,
d(91) = 9 + 1 + 91 = 101

이 때, n을 d(n)의 제네레이터라고 하고, 제네레이터가 없는 숫자를 셀프 넘버라고 한다. ex) 1, 3, 5, 7, 9, 20, 31은 셀프 넘버이다.

1 이상이고 5000보다 작은 모든 셀프 넘버들의 합을 구하라.
'''

# d(n) = a + b + 10*a + b
#      = 11*a + 2b

def getGenerator(n):
    if n < 10: return n
    else: return n%10 + getGenerator(n//10)

generators = [getGenerator(i) + i for i in range(5000)]
print(sum(set(range(5000)) - set(generators)))

# 코딩도장 해설
print(sum(set(range(1, 5000)) - {x + sum([int(a) for a in str(x)]) for x in range(1, 5000)}))