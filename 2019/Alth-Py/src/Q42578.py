# https://programmers.co.kr/learn/courses/30/lessons/42578
from functools import reduce

def solution(clothes):
    answer = 1
    hash_clothes = {}

    for c in clothes:
        if hash_clothes.get(c[1]):
            hash_clothes[c[1]].append(c[0])
        else:
            hash_clothes[c[1]] = [c[0]]

    # for h in hash_clothes:
    #     answer *= len(hash_clothes[h])+1
    answer = reduce(lambda x, y: x*y, [len(hash_clothes[h])+1 for h in hash_clothes])-1

    return answer

clothes = [
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"]
]
result = 5

print(solution(clothes))