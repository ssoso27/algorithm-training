'''
1일차(6) - switch 구현 (by dict)
'''

# 파이썬은 스크립트 언어이기 때문에, 중간에 멈추면 안됨
# get() : 어떤 패턴을 찾고, 그 패턴이 없다면 에러 대신 지정된 다른 값을 return
jeju = {'melon' : 5000, 'apple' : 2500, 'banana' : 3000}
print(jeju.get('a', "unknown"))

# 파이썬에는 switch가 없다. 파이썬스럽지 않기 때문이다.
# dict로 switch 구현하기
def week(x):
    return {
        0: 'mon',
        1: 't',
        2: 'w',
        3: 't',
        4: 'f',
        5: 's',
        6: 's', # 마지막의 ','가 없으면, 버전관리프로그램 등에서 에러가 날 수 있다.
    }.get(x, 'unknown')

print(week(2))
print(week(7))