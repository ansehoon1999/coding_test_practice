import sys



def paper(y, x, n) :
    global count_1
    global count0
    global count1 
    
    init = graph[y][x]
    for i in range(y, y+n) :
        for j in range(x, x+n) :
            if init != graph[i][j] :
                paper(y, x, n//3)
                paper(y, x + n//3, n//3)
                paper(y, x + n//3 * 2,  n//3)
                paper(y + n//3, x, n//3)
                paper(y + n//3, x + n//3, n//3)
                paper(y + n//3, x + n//3 * 2,  n//3)
                paper(y + n//3 * 2, x, n//3)
                paper(y + n//3 * 2, x + n//3, n//3)
                paper(y + n//3 * 2, x + n//3 * 2,  n//3)    
            
                return
    
    if init == 0 :
        count0 += 1
    elif init == 1 :
        count1 += 1
    elif init == -1 :
        count_1 += 1
        
    return

N = int(sys.stdin.readline())
graph = []
for _ in range(N) :
    tmp = list(map(int, sys.stdin.readline().rstrip().split()))
    graph.append(tmp)


global count_1
global count0
global count1 
count1 = 0
count0 = 0
count_1 = 0

paper(0,0,N)

print(count_1)
print(count0)
print(count1)