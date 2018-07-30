'''
1일차(3) - 리스트
'''

x = []
print(dir(x))
# append: 리스트가 아닌 요소 추가 가능
x.append(100)
print(x)
# extend: 리스트를 넣어서 확장
x.extend([1, 3])
print(x)

x.clear()
for i in range(10):
    x.append(i)
print(x)
print("=========================================")

x.clear()
print([i for i in range(4, 10)]) # 지능형 리스트

# 지능형 리스트로 구구단 만들기
gugudan = ["{} x {} = {}".format(i, j, i*j)
           for i in range(2, 10)
            for j in range(1, 10)]
print(gugudan)
print("=========================================")

# 정렬
x = [3, 7, 4, 1, 2, 4]
# sorted(x): x를 수정하지 않고, 정렬된 값 return
print(sorted(x))
print(x)
# x.sort(): x가 수정이 됨, None return
print(x.sort())
print(x)

print("=========================================")
'''
index("aa") : 해당 문자열에서 해당 패턴이 첫번째로 나타나는 index return
del myList(2) : 해당 리스트의 2번째 값 제거 
remove(x) : 해당 리스트에서 첫번째로 나오는 x 제거 
pop() : 마지막 원소 제거
pop(n) : n번째 원소 제거
'''