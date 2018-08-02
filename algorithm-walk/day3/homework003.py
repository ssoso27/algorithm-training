'''
과제 3) 재귀함수를 이용하여 입력 받은 두 수의 최대공약수를 구하여라.
    > 유클리드 호제법 사용
'''
def gcd(a, b):
    if a % b == 0:
        print(b)
    else:
        return gcd(b, a%b)

gcd (150, 6)