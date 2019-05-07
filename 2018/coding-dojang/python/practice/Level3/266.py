'''
[Spiral Array]
- http://codingdojang.com/scode/266?answer_mode=hide

문제는 다음과 같다:

6 6

  0   1   2   3   4   5
 19  20  21  22  23   6
 18  31  32  33  24   7
 17  30  35  34  25   8
 16  29  28  27  26   9
 15  14  13  12  11  10

위처럼 6 6이라는 입력을 주면 6 X 6 매트릭스에 나선형 회전을 한 값을 출력해야 한다.

'''

class MovePoint:
    direction = 0
    moveX, moveY = 1, 0

    def changeDirection(self, d):
        self.direction = d

        if(self.direction == 0):
          self.moveX, self.moveY = 1, 0
        elif(self.direction == 1):
          self.moveX, self.moveY = 0, 1
        elif(self.direction == 2):
          self.moveX, self.moveY = -1, 0
        elif(self.direction == 3):
          self.moveX, self.moveY = 0, -1

x, y = map(int, input().split(" "))
matrix = [[-1 for a in range(x)] for b in range(y)]
movePoint = MovePoint()

i, j, number = 0, 0, 0
while number < x * y:
    matrix[i][j] = number
    number += 1

    if movePoint.direction == 0 and (j == x-1 or matrix[i][j+1] != -1):
        movePoint.changeDirection(1)
    elif movePoint.direction == 1 and (i == y-1 or matrix[i+1][j] != -1):
        movePoint.changeDirection(2)
    elif movePoint.direction == 2 and (j == 0 or matrix[i][j-1] != -1):
        movePoint.changeDirection(3)
    elif movePoint.direction == 3 and (i == 0 or matrix[i-1][j] != -1):
        movePoint.changeDirection(0)

    j += movePoint.moveX
    i += movePoint.moveY

for m in range(len(matrix)):
    print(matrix[m])