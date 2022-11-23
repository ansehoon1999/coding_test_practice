
import sys
sys.setrecursionlimit(100000)
def D (n) :
    n = n * 2

    if n > 9999 :
        n = n % 10000
    
    return n

def S (n) :
    if n == 0 :
        n = 9999
    else :
        n = n - 1
    
    
    return n

def L (n) :
    tmp = n // 1000

    return n % 1000 * 10 + tmp

def R (n) :

    tmp = n % 10

    return n // 10 + 1000 * tmp

def dfs (a, b, arr) :
    visited = [False] * 10000
    queue = deque()
    queue.append((a, arr))
    visited[a] = True

    while queue :
        node = queue.popleft()
        

        if node[0] == b :
            print(node[1])
            break

        for i in range(4) :
            if i == 0 :
                if visited[D(node[0])] == False :
                    queue.append((D(node[0]), node[1] + 'D'))
                    visited[D(node[0])] = 1

            elif i == 1 :
                if visited[S(node[0])] == False :
                    queue.append((S(node[0]), node[1] + 'S'))
                    visited[S(node[0])] = 1
                
            elif i == 2 :
                if visited[L(node[0])] == False :
                    queue.append((L(node[0]), node[1] + 'L'))
                    visited[L(node[0])] = 1    

            elif i == 3 :
                if visited[R(node[0])] == False :
                    queue.append((R(node[0]), node[1] + 'R'))
                    visited[R(node[0])] = 1


from collections import deque

n = int(sys.stdin.readline())
for _ in range(n) :
    
    a, b = map(int, sys.stdin.readline().split())
    dfs(a, b, '')

