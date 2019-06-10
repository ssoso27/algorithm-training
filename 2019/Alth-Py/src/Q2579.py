# https://www.acmicpc.net/problem/2579
import sys


def isLast(current):
    return current == (n-1)

def isSecondOfLast(current):
    return current == (n-2)

def bigger(num1, num2):
    if num1 > num2: return num1
    else: return num2

def solution(footprint, current=0, sum=0, onestep=0):
# def solution(current=0, sum=0, onestep=0):
    if (onestep > 0) and not (onestep % 2):
        return -9223372036854775806

    max = 0
    sum = sum + scores[current]
    footprint.append(current)
    print(f'current : {current}, sum : {sum}, onestep : {onestep}')
    print(footprint)
    print('='*20)

    if isSecondOfLast(current):
        max = bigger(max, solution(footprint, current + 1, sum, onestep + 1))
        footprint.append('back ' + str(current))
        # max = bigger(max, solution(current+1, sum, onestep+1))
    elif isLast(current):
        return sum
    else:
        for i in range(1, 3):
            max = bigger(max, solution(footprint, current+i, sum, onestep+(i%2)))
            footprint.append('back ' + str(current))
            # max = bigger(max, solution(current+i, sum, onestep+(i%2)))

    return max

scores = []
n = int(input())
for i in range(n):
    scores.append(int(input()))

print(solution([]))

