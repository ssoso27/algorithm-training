def get_mean(lst):
    return sum(lst)/len(lst)

def get_var(lst):
    m = get_mean(lst)
    return sum([(n - m)**2 for n in lst])/len(lst)

def get_std(lst):
    return get_var(lst)**(1/2)

def solution(n, k, populars):
    min = 9223372036854775807

    for i in range(n-k+1):
        for j in range(k, n):
            if i+j >= n: break
            std = get_std(populars[i: i+j])
            if min > std: min = std
    print(min)

nk = [*map(int, input().split())]
populars = [*map(int, input().split())]
solution(nk[0], nk[1], populars)
