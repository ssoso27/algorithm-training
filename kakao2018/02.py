'''
02) 실패율

실패율
    = 스테이지에 도달했으니 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수

N : 전체 스테이지의 개수
stages : 게임 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열
return : 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열

[제한사항]
- stages에는 1 이상 N+1 이하의 자연수가 담겨있다.
- 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
- 단, N+1은 마지막 스테이지까지 클리어 한 사용자를 나타낸다.
- 만약 실패율이 같은 스테이지가 있다면, 작은 번호의 스테이지가 먼저 오도록 하면 된다.
- 스테이지에 도달한 유저가 없는 경우, 해당 스테이지의 실패율은 0으로 정의한다.
'''

def solution(N, stages):
    result = [0] * N
    arrives = [0] * N

    for stage in stages:
        for i in range(stage):
            arrives[i] += 1

    for i, arrive in enumerate(arrives):
        sum = stages.count(i)


N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
solution(N, stages)