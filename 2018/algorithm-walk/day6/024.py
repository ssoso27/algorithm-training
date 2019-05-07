'''
6일차(1) - 카카오 입사문제

Q) 1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오.
(단, 점들의 배열은 모두 정렬되어 있다고 가정한다.)

[입력]
S = [1, 3, 4, 8, 13, 17, 20]

[출력]
(3, 4)
'''
def solution(list) :
    min = 9223372036854775807
    result = []
    for i, n in enumerate(list[:len(list)-1]) :
        dis = abs(n - list[i+1])
        if dis < min:
            min = dis
            result = n, list[i+1]
    print(result)

s = [1, 3, 4, 8, 13, 17, 20]
solution(s)
print("====================")

# 해설
s = [1, 3, 4, 8, 13, 17, 20]
pairs = list(zip(s[0: ], s[1: ])) # 순서쌍 새로운 리스트 만듬
print(list(pairs))
pairs.sort(key = lambda x:abs(x[1] - x[0])) # 순서쌍의 차를 기준으로 sorting
print(pairs[0])