'''
1일차(4) - Set
'''

x = {100, 200, 300, 400}
y = {400, 500, 600}
print(dir(x))
print(len(x))
x.add(500)
print(x)

# 삭제
# x.pop() : 마지막 index 삭제이나, set에는 index가 없으므로, 임의의 값이 삭제된다.
# x.discard(value) : 해당 value 삭제
x.discard(100)

print(x)
# x.union(y) : 두 개의 set 결합
print(x.union(y))