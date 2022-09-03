import sys

t = int(sys.stdin.readline)

def search(x, y) :
    if x < 0 or x >= m or y < 0 or y >= n :
        return
    
    if arr[x][y] == 0 :
        return
    
    arr[x][y] = 0

    search(x+1, y)
    search(x, y+1)
    search(x-1, y)
    search(x, y-1)


for i in range(t) :
    n, m, k = map(int, input().split())

    count = 0
    arr = [[0] * n for _ in range(m)]
 
    for j in range(k) :
        x, y = map(int, input().split())
        arr[y][x] = 1    

    for x in range(m) :
        for y in range(n) :
            if arr[x][y] == 1 :
                search(x, y)
                count = count + 1
    
    print(count)
            


