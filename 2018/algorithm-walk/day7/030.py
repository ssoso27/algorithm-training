'''
7일차(4) - 카카오 입사 문제 - 다트게임
url : http://codingdojang.com/scode/571

카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

1. 다트 게임은 총 3번의 기회로 구성된다.
2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고
    각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수^1 , 점수^2 , 점수^3 )으로 계산된다.
4. 옵션으로 스타상(*) , 아차상(#)이 존재하며
    스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
    아차상(#) 당첨 시 해당 점수는 마이너스된다.
5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다.
    이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다.
    이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다.
    이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
'''
def sliceStage(input_str):
    stages = [] * 3
    if len(input_str) == 6:
        return [input_str[i: i+2] for i in range(3)]
    else:
        stages = input_str.split("#").split("*")
        for i, s in enumerate(stages):
            while len(s) > 3:
                stages.insert(i-1, s[ :2])
                del s[ :2]

def solution(input_str):
    stages = sliceStage(input_str)
    scores = [0] * 3

    for i, row in enumerate(stages):
        row.replace("S", "1").replace("D", "2").replace("T", "3")
        scores[i] = int(row[0]) ** int(row[1])

        if row.contains("*"):
            if i == 0: scores[i] *= 4
            else:
                scores[i] *= 2
                scores[i-1] *= 2
        elif row.contains("#"):
            scores[i] *= -1

    print(sum(scores))

solution("1S2D*3T")

# 해설(코딩도장 - 박범수)
def dart(s):
    score = []
    n = ''
    for c in s:
        if c.isnumeric():
            n += c
        elif c == 'S':
            score.append(int(n) ** 1)
            n = ''
        elif c == 'D':
            score.append(int(n) ** 2)
            n = ''
        elif c == 'T':
            score.append(int(n) ** 3)
            n = ''
        elif c == '*':
            if len(score) > 1:
                score[-2] *= 2
            score[-1] *= 2
        elif c == '#':
            score[-1] *= -1
        # print(c, score)
    print(s, sum(score))

# 해설(코딩도장 - songci)
import re


def dart(inp):
    shot = re.findall(r'\d{1,2}[SDT][*#]?', inp)

    opt = [1,1,1]
    for i, s in enumerate(shot):
        if s[-1] == '#':
            opt[i] *= -1
            shot[i] = shot[i][:-1]
        elif s[-1] == '*':
            opt[i] *= 2
            shot[i] = shot[i][:-1]
            if i:
                opt[i-1] *= 2

    point = [(int(s[:-1]) ** '0SDT'.find(s[-1]) * o) for s, o in zip(shot, opt)]

    return sum(point)


print(dart('1S2D*3T'))
print(dart('1D2S#10S'))
print(dart('1D2S0T'))
print(dart('1S*2T*3S'))
print(dart('1D#2S*3S'))
print(dart('1T2D3D#'))
print(dart('1D2S3T*'))