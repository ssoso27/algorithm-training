'''
7일차(2) - tuple

가변 : dict, list
불변 : 숫자, 문자열, tuple
'''
x = [1, 2, 3]
y = (10, 20, 30, x) # call by object reference -> 참조를 전달 (참조불변)
x[0] = 100
print(y) # 불변인 y가 변한 것 같지만, 저장하고 있는 객체들의 집합이 바뀔 수는 없으므로 불변이라고 한다.