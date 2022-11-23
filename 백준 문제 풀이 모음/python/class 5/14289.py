import sys

input = sys.stdin.readline
MOD = 1000000007


def multiply_matrix(matrix1, matrix2):
    return [[sum(matrix1[i][k]*matrix2[k][j] % MOD for k in range(n)) % MOD
             for j in range(n)] for i in range(n)]


def solution(D):
    # DP 초기화
    dp1 = [[0]*n for _ in range(n)]
    for k, v in graph.items():
        for adj in v:
            dp1[k][adj] = 1

    dp2 = [[0]*n for _ in range(n)]
    for i in range(n):
        dp2[i][i] = 1

    # 행렬 제곱
    while D > 0:
        if D % 2 == 1:
            dp2 = multiply_matrix(dp1, dp2)
            D -= 1
        dp1 = multiply_matrix(dp1, dp1)
        D //= 2

    return dp2[0][0]


if __name__ == '__main__':
    n, m = map(int, input().split())

    graph = {i: [] for i in range(n)}
    for _ in range(m):
        a, b = map(int, input().split())
        a -= 1
        b -= 1
        graph[a].append(b)
        graph[b].append(a)

    D = int(input())

    print(solution(D))