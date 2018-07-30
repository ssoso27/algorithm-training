'''
1일차(2) - 형변환
'''

x = input('나이를 입력해주세요.')
print(x)
print(x + x) # x는 string이기 때문에 문자열 붙이기 연산이 됨
print(int(x) + int(x)) # toInt 형변환

# 딕셔너리 형변환
나 = [('키', '180'), ('나이', 20)]
print(나) # 리스트
print(dict(나)) # dict

# ASCII CODE 에서 char <-> int
print(chr(65))
print(ord('A'))

# 기타 형변환
str()
float()
bool([''])
set()
list()
tuple()
hash()
hex() # 16진수
oct() # 8진수