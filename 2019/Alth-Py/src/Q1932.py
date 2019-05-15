def solution(row, column, sum):
    max = 0
    sum += triangle[row][column]

    print(f'[{row}, {column}] checked. sum = {sum}')
    print('='*10)

    if row + 1 != triangleSize:
        for i in range(0, 2):
            result = solution(row+1, column+i, sum)
            if result > max:
                max = result
    else:
        return sum

    return max

triangle = []
triangleSize = int(input())
for i in range(triangleSize):
    line = input()
    triangle.append([int(i) for i in line.split()])

result = solution(0, 0, 0)
print(f"결과 : {result}")