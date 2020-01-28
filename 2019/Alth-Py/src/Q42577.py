# https://programmers.co.kr/learn/courses/30/lessons/42577?language=python3

def solution(phone_book):
    answer = True
    my_book = {}
    for phone in sorted(phone_book):
        temp = my_book.get(phone[0])
        if temp:
            for saved_phone in temp:
                l = min(len(saved_phone), len(phone))
                if saved_phone[:l] == phone[:l]:
                    return False
            temp.append(phone)
        else:
            temp = [phone]
        my_book[phone[0]] = temp
    return answer

phone_book = (
    ["119", "97674223", "1195524421"],
    ["123","456","789"],
    ["12","123","1235","567","88"],
    ["1", "51", "411", "51", "41", "40"]
)
answer = [False, True, False]

print(solution(phone_book[3]))