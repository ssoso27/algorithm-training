'''
2일차(1) - stack 구현

ADT (Abstract Data Type)
 - 기능의 구현 부분을 나타내지 안혹 순수한 기능이 무엇인지 나열한 것
 - 구현과 분리되는 추상적 개념

stack 구현에 필요한 요소 (ADT)
 - s.top()
 - s.pop()
 - s.push()
 - s.empty()
'''

class Stack(list):
    push = list.append

    def is_empty(self):
        if not self:
            return True
        else:
            return False

    def peek(self):
        return self[-1]

s = Stack()
s.push(1)
s.push(4)
s.push(6)
s.push(2)

print(s)

while s:
    print(s.pop())