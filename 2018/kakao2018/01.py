'''
01) 오픈채팅방

- 입장
[닉네임]님이 들어왔습니다.

-퇴장
[닉네임]님이 나갔습니다.

-닉네임 변경
1) 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
2) 채팅방에서 닉네임을 변경한다.

-닉네임 변경 시, 기존에 출력되었던 닉네임들도 전부 변경됨
-중복 닉네임 허용

-채팅방 출입, 닉네임 변경 기록이 담긴 문자열 배열 record
==> 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 형태로 return 하도록 solution 함수를 완성하라.

- 모든 유저는 [유저 아이디]로 구분하며, [닉네임]을 갖고 있다.
- record 배열
    Enter uid1234 Muzi
    Leave uid1234
    Change uid1234 Muzi
'''

def solution(record):
    copy_record = []
    result = []
    uid_nickname = {}

    for i, n in enumerate(record):
        copy_record.insert(i, n.split(" "))

    # uid - nickname mapping
    for instruction in copy_record:
        if instruction[0] == "Enter" or instruction[0] == "Change":
            uid_nickname[instruction[1]] = instruction[2]

    for instruction in copy_record:
        if instruction[0] == "Enter":
            result.append(uid_nickname[instruction[1]]+"님이 들어왔습니다.")
        elif instruction[0] == "Leave":
            result.append(uid_nickname[instruction[1]]+"님이 나가셨습니다.")

    print(result)

record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]
solution(record)
