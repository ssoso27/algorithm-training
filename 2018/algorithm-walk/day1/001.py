'''
1일차(1) - python 내장함수 살펴보기
'''

x = [100, 200, 300, 400]
y = [10, 20, 30, 40]

def double(x): return x*2

print (max(x))
print (min(x))
print (len(x))
print (type(x))
print (sum(x))
print (dir(x))
print ("-----------------")
print(type(range(20)))
# map()은 해당 map object의 memory 값만 반환함.
# 추후 사용자가 호출하면 실행
print(map(double, x))
print(list(map(double, x)))
print ("-----------------")
z = list(zip(x, y))
for i, j in z:
    print (i, j)
print ("-----------------")
# index가 1부터 시작하는 새로운 indexing 을 매겨, for.
for i, j, in enumerate(x, 1):
    print (i, j)