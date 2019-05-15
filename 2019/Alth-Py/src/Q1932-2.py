def solution():
    max = 0
    for i in range(triangleSize):
        sum = maxSum(triangleSize-1, i)
        if sum > max: max = sum

    return max

def maxSum(row, column):
    if maxValues[row][column] != -1:
        return maxValues[row][column]
    else:
        sum = 0
        if row == 0 and column == 0: sum = triangle[row][column]
        elif column == 0:
            sum = maxSum(row-1, column) + triangle[row][column]
        elif column == row:
            sum = maxSum(row-1, column-1) + triangle[row][column]
        else:
            sum = max(maxSum(row-1, column-1), maxSum(row-1, column)) + triangle[row][column]
        maxValues[row][column] = sum
        return sum

triangle = []
triangleSize = int(input())
for i in range(triangleSize):
    line = input()
    triangle.append([int(i) for i in line.split()])
maxValues = [[-1] * (i+1) for i in range(triangleSize)]

result = solution()
print(result)