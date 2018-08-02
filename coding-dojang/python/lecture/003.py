'''
date: 20180802

FizzBuzz는 매우 간단한 프로그래밍 문제이며 규칙은 다음과 같습니다.

1. 1에서 100까지 출력
2. 3의 배수는 Fizz 출력
3. 5의 배수는 Buzz 출력
4. 3과 5의 공배수는 FizzBuzz 출력
즉, 1부터 100까지 숫자를 출력하면서 3의 배수는 숫자 대신 'Fizz', 5의 배수는 숫자 대신 'Buzz', 3과 5의 공배수는 숫자 대신 'FizzBuzz'를 출력하면 됩니다.

설명을 보면서 따라하기 전에 스스로 이 문제를 풀어보는 것이 좋습니다. 문제를 풀지 못해도 고민한 만큼 기억에 오래 남습니다.
'''

for i in range(1, 101):
    if i%15 == 0: print('FizzBuzz', end=' ')
    elif i%5 == 0: print('Buss', end=' ')
    elif i%3 == 0: print('Fizz', end=' ')
    else: print(i, end=' ')