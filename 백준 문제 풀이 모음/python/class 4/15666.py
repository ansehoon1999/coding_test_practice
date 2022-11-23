import sys
input = sys.stdin.readline



def dfs (idx) :
    global tmp
    global visited



    if idx == m :
        answer.add(tuple(sorted(tmp)))
        return

    for i in range(n):

        tmp.append(arr[i])
                        
        dfs(idx + 1)
        tmp.pop()

n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))


tmp = []
answer = set()

dfs(0)

for i in sorted(answer):
    print(*i)