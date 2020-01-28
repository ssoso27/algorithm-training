def solution(progresses, speeds):
    answer = []
    while len(progresses) > 0:
        feature = 0
        idx = 0
        while idx < len(progresses):
            progresses[idx] += speeds[idx]
            if idx == 0 and progresses[idx] >= 100:
                feature += 1
                progresses.pop(idx)
                speeds.pop(idx)
            else:
                idx += 1

        if feature > 0:
            answer.append(feature)
    return answer

progresses = [93, 30, 55]
speeds = [1, 30, 5]
result = [2, 1]

print(solution(progresses, speeds))