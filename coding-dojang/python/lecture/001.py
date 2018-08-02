'''
date: 20180802

연습문제 8.5 : 한 번에 정수 세 개 입력받기
https://dojang.io/mod/page/view.php?id=870

다음 소스 코드를 완성하여 정수 세 개를 입력받고 합계가 출력되게 만드세요.

[소스 코드]
print(a + b + c)

[실행 결과]
10 20 30
60

'''

a, b, c = map(int, input().split())
print (a + b + c)