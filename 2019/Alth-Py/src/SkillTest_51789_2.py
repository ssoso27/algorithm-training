def solution(participant, completion):
    answer = ''
    runner = {}

    for p in participant:
        if runner.get(p):
            runner[p] = runner.get(p) + 1
        else:
            runner[p] = 1

    for c in completion:
        cnt = runner.get(c)
        if cnt > 1:
            runner[c] = runner[c] - 1
        else:
            runner.pop(c)

    answer = list(runner.keys())[0]
    return answer

participant = ["mislav", "stanko", "mislav", "ana"]
completion = ["stanko", "mislav", "ana"]

print( solution(participant, completion) )