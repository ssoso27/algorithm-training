'''
과제 2) 재귀함수를 이용하여 입력 받은 n이하의 피보나치 수열을 구하라.
'''
def fibonachi(a, b, n):
    if ((a + b) <= n):
        print(a + b, end=',')
        return fibonachi(b, a+b, n)

print('1,1,', end='')
fibonachi(1, 1, 100)