'''
과제 1) 재귀함수를 이용하여 입력 받은 n까지의 합을 구하라
'''
def func_sum(n):
    if (n == 1): return 1
    else: return n + func_sum(n-1)

print(func_sum(5))