'''
1일차(5) - dict
'''

jeju = {'melon' : 5000, 'apple' : 2500, 'banana' : 3000}
print(dir(jeju))
print(jeju.keys()) # return key list
print(jeju.values()) # return value list
print(jeju.items()) # return (key, value) tuple list
print("==============================")

# copy
#seoul = jeju.copy() # 값만 복사
seoul = jeju # 객체 복사
seoul['banana'] = 100000 # seoul과 jeju가 같은 객체. => jeju가 변경된다
print(jeju)