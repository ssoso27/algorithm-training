'''
3일차(3) - 재귀함수로 factorial 구현하기
* 모든 반복은 재귀로 구현할 수 있다.
'''
def factorial(last):
    if (last == 1): return 1
    else: return factorial(last-1) * last

print(factorial(5))

'''
x   f(x)    return
5   f(5)    5*f(4) = 120
4   f(4)    4*f(3) = 24
3   f(3)    3*f(2) = 6
2   f(2)    2*f(1) = 2
1   f(1)    1
'''