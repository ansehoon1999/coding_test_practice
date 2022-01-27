from sys import stdin


n, m = map(int, stdin.readline().split())

numbers = [[0] * (n + 1)]

for _ in range(n):
    nums = [0] + [int(x) for x in stdin.readline().split()]
    numbers.append(nums)

# prefix sum 행렬 만들기


for i in range(1, n + 1):
    for j in range(1, n):
        numbers[i][j + 1] += numbers[i][j]

for j in range(1, n + 1):
    for i in range(1, n):
        numbers[i + 1][j] += numbers[i][j]

for _ in range(m):
    x1, y1, x2, y2 = map(int, stdin.readline().split())
    print(numbers[x2][y2] - numbers[x1 - 1][y2] - numbers[x2][y1 - 1] + numbers[x1 - 1][y1 - 1])