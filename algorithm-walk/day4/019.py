'''
4일차(2) - 선택정렬
'''
def select_sort(list): # 반복문
    new_list = []
    while list:
        min_index = get_min_index(list)
        new_list.append(list.pop(min_index))
    return new_list

def select_sort2(list): # 재귀함수
    if len(list) == 1: print(list[0])
    elif list:
        print(list.pop(get_min_index(list)), end=' ')
        select_sort2(list)

def get_min_index(list):
    min = 0
    for i, n in enumerate(list):
        if list[min] > n: min = i
    return min

list = [6, 2, 4241, 35, 7, 88, 2, 3, 6]
print(select_sort(list))

list2 = [7, 3, 2, 4, 6, 6, 8, 1, 2, 9]
select_sort2(list2)

# 해설 - 내장함수 최소화
def 최솟값_인덱스_리턴_함수(입력_리스트_둘):
    최솟값인덱스 = 0
    for 증가값 in range(1, len(입력_리스트_둘)):
        if 입력_리스트_둘[증가값] < 입력_리스트_둘[최솟값인덱스]:
            최솟값인덱스 = 증가값
    return 최솟값인덱스

def 선택정렬(입력_리스트_하나):
    최종결과값 = []
    while 입력_리스트_하나:
        최솟값_인덱스_저장 = 최솟값_인덱스_리턴_함수(입력_리스트_하나)
        최솟값 = 입력_리스트_하나.pop(최솟값_인덱스_저장)
        최종결과값.append(최솟값)
    return 최종결과값

주어진리스트 = [6, 12, 4, 2, 745, 4, 1, 87, 66]

print(선택정렬(주어진리스트))