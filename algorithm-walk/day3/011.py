'''
3일차(1) - 010.py 를 데크로 구현하기

데크 = 양방향 큐.
'''
import collections

data = input('회전수, 문자열 입력 : ').split()
result = collections.deque(data[1:])
result.rotate(int(data[0]))
print(' '.join(result))