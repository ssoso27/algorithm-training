'''
2일차(3) - 리스트 회전 문제
url : http://codingdojang.com/scode/400

아래 조건에 따라 리스트를 회전하는 프로그램을 작성하시오.

[조건]
입력값은 한 행의 문자열로 주어지며, 각 값은 공백으로 구분된다.

첫 번째 값은 리스트를 회전하는 양과 방향(음수의 경우 좌측으로, 양수의 경우 우측으로 회전)이다.

첫 번째 값을 제외한 나머지 값은 리스트의 각 항목의 값이다.

회전된 리스트를 문자열로 출력한다.

구현에 이용할 자료구조에 대한 조건이나 제약은 없다.

입력되는 리스트의 항목의 개수는 유한한다.

[입출력 예]
예 2)

입력: 4 가 나 다 라 마 바 사

출력: 라 마 바 사 가 나 다
'''

# 해설
data = input('회전수, 문자열 입력 : ').split()
rotate = int(data.pop(0))
result = [None]*len(data)
for i in range(len(data)):
    result[(i+rotate)%len(data)] = data[i]
print(' '.join(result))