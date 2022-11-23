import sys
input = sys.stdin.readline



def dfs (idx) :
    global tmp
    global visited


    if idx == m :
        answer.add(tuple(tmp))
        return

    for i in range(n):
        if visited[i]  :
            continue
        tmp.append(arr[i])
        visited[i] = True
        dfs(idx + 1)
        visited[i] = False
        tmp.pop()

n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))

visited = [False] * n

tmp = []
answer = set()

dfs(0)

for i in sorted(answer):
    print(*i)