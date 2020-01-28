# https://programmers.co.kr/learn/courses/30/lessons/42579
def solution(genres, plays):
    answer = []
    hash_map = {}

    # hash_map = { '장르' : [고유번호 리스트] }
    for i in range(len(genres)):
        if hash_map.get(genres[i]):
            hash_map[genres[i]].append(i)
        else:
            hash_map[genres[i]] = [i]

    # 각 장르 고유번호 리스트를
    #   plays[고유번호]의 값이 큰 순으로 sort
    for k in hash_map:
        hash_map[k] = sorted(hash_map[k])
        hash_map[k] = sorted(hash_map[k], key=lambda x: plays[x], reverse=True)

    # 총 재생횟수가 많은 장르 2개를 큰 순서로 뽑음
    # max_ganres = ['장르1', '장르2']
    max_ganres = sorted(hash_map, key= lambda x: sum([plays[idx] for idx in hash_map[x]]), reverse=True)[:2]
    # max_ganres = sorted(hash_map, key= lambda g: sum(map(lambda x: plays[x], hash_map[g])), reverse=True)[:2]

    # answer에 집어넣음
    for g in max_ganres:
        if len(hash_map[g]) > 1:
            answer.extend(hash_map[g][:2])
        else:
            answer.append(hash_map[g][0])

    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
# result = [4, 1, 3, 0]

# genres = ["aa", "bb", "aa", "bb"]
# plays = [0, 40, 0, 30]

print(solution(genres, plays))