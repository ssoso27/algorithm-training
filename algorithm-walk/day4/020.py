'''
4일차(3) - 삽입정렬
'''

def insert_sort(list): # 반복문
    new_list = []
    while list:
        n = list.pop(0)
        index = get_index(new_list, n)
        try:
            new_list.insert(index, n)
        except:
            new_list.append(n)
    return new_list

def get_index(list, input):
    if not list: return 0
    for i, n in enumerate(list):
        if input <= n: return i

list = [123, 53, 23, 542, 3, 123]
print(insert_sort(list))

# 해설
def 결과값에서_삽입값이들어갈_인덱스(결과값, 삽입값):
    for 증가값 in range(0, len(결과값)):
        if 삽입값 < 결과값[증가값]:
            return 증가값
    return len(결과값)

def 삽입정렬(입력_리스트_하나):
    결과값 = []
    while 입력_리스트_하나:
        삽입값 = 입력_리스트_하나.pop(0)
        삽입_값_인덱스 = 결과값에서_삽입값이들어갈_인덱스(결과값, 삽입값)
        결과값.insert(삽입_값_인덱스, 삽입값)
    return 결과값

주어진리스트 = [1242, 64, 21, 66, 2, 2, 45, 1, 7, 555]
print(삽입정렬(주어진리스트))