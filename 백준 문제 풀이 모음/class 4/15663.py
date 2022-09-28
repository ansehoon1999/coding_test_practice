import sys
input = sys.stdin.readline

def bt(idx) :
    if len(tmp) == m :
        ans.add(tuple(tmp))
        return
    for i in range(n) :
        if visited[i] :
            continue
        tmp.append(arr[i])
        visited[i] = True
        bt(idx + 1)
        visited[i] = False
        tmp.pop()



n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
visited = [False] * n
tmp, ans =  [], set()

bt(-1)
for i in sorted(ans) :
    print(*i)