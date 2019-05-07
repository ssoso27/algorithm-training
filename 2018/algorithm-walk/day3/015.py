'''
3일차(5) - 문자열 거꾸로 출력하기
'''
x = 'yangsohee'
print(x[::-1])

# 재귀함수
def 문자열뒤집기(str):
    if not str: return None
    else:
        문자열뒤집기(str[1:])
        print(str[0], end='')

문자열뒤집기('yangsohee')