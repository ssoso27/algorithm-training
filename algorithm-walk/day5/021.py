'''
5일차(1) - 아마존 면접문제

다음과 같은 형태의 배열을

[a1,a2,a3...,an,b1,b2...bn]

다음과 같은 형태로 바꾸시오

[a1,b1,a2,b2.....an,bn]

단, 추가적인 저장장소를 사용하지 말아야한다.
'''

def getIndex(list, target):
    for i, n in enumerate(list):
        if n[1:] == target[1:]: return i+1
    return len(list)

def changeArray(list):
    half_length = len(list)//2
    for i, n in enumerate(list[half_length: ]):
        index = getIndex(list[: half_length], n)
        list.insert(index, list.pop(i + half_length))
    return list

list1 = ['a'+str(i) for i in range(1,10)]+(['b'+str(i) for i in range(1, 10)])
print(changeArray(list1))

# 해설
def changeArray2(list):
    half_length = len(list)//2
    for i in range(half_length):
        list.insert(1 + (2*i), list.pop(half_length + i))
    return list

list2 = ['a'+str(i) for i in range(1,10)]+(['b'+str(i) for i in range(1, 10)])
print(changeArray2(list2))