'''
과제 1) python으로 큐 구현하기

1. 데이터를 큐에 Rear방향으로 저장(Enqueue)한다.
2. 데이터를 큐에서 Front방향으로 꺼내(Dequeue)낸다. 데이터를 Dequeue하고 나서는 큐에서 해당 데이터를 삭제된다.
3. 데이터를 큐에서 꺼내전에 잠깐 참조(Peek)할 수 있다.
4. 데이터가 비어 있다면(is_empty), Pop연산을 실행할 수 없다.
5. 데이터가 꽉차 있다면(is_full), Push연산을 실행할 수 없다. (단, 저장할 데이터의 개수를 한정해야함)
6. 큐에 있는 모든 데이터를 차례대로 출력할 수 있어야 한다.
'''

class Queue():
    length = 0

    def __init__(self, length):
        self.length = length

    def enqueue(self, data):
    def dequeue(self):
    def peek(self):
    def pop(self):
    def push(self):
    def isEmpty(self):
    def isFull(self):
