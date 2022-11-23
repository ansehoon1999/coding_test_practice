N = int(input())
count = 0

# row : 행 / right : 우상향 대각선 / left : 좌상향 대각선
row, right, left = [False] * N, [False] * (2 * N - 1), [False] * (2 * N - 1)

def solve(j):
    global count
    # N개의 퀸을 다 놓았을 때
    if j == N:
        count += 1
        return

    for i in range(N):
        # 모든 방향이 False일 때 = 퀸을 놓을 수 있을 때
        if not (row[i] or right[j + i] or left[N - 1 + j - i]):
            row[i] = right[j+i] = left[N-1+j-i] = True
            solve(j+1)
            row[i] = right[j+i] = left[N-1+j-i] = False


solve(0)
print(count)