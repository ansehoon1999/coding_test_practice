import sys, copy
input = sys.stdin.readline

R, C, T = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(R)]



dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def clean_top():
    dx, dy = (0, -1, 0, 1), (1, 0, -1, 0)
    x, y, d = minus[0], 1, 0
    prev = 0

    while True:
        nx, ny = x + dx[d], y + dy[d]

        if x == minus[0] and y == 0:
            break
        if not 0 <= nx < R or not 0 <= ny < C:
            d += 1
            continue

        graph[x][y], prev = prev, graph[x][y]
        x, y = nx, ny

def clean_bottom () :
    dx, dy = (0,1,0,-1), (1,0,-1,0)
    x, y, d = minus[1], 1, 0
    prev = 0

    while True :
        nx, ny = x + dx[d], y + dy[d]

        if x == minus[1] and y == 0 :
            break
        if not 0 <= nx < R or not 0 <= ny < C :
            d += 1
            continue
        graph[x][y], prev = prev, graph[x][y]
        x, y = nx, ny
minus = []
for _ in range(T) :
    result = []
    for _ in range(R) :
        result.append([0] * C)

    for i in range(R) :
        for j in range(C) :
            if graph[i][j] == -1 :
                minus.append(i)
                result[i][j] = -1
                continue
            count = 0
            tmp = 0
            for k in range(4) :
                ay = i + dy[k]
                ax = j + dx[k]

                if (ay < 0 or ay >= R or ax < 0 or ax >= C) or graph[ay][ax] == -1 :
                    continue
                else :
                    count += 1
                    tmp += (graph[ay][ax]//5)
            
            tmp += graph[i][j] - ( graph[i][j] // 5) * count
            result[i][j] = tmp

    graph = copy.deepcopy(result)
    clean_top()
    clean_bottom()

    # print("graph===============")
    # for i in range(R) :
    #     for j in range(C) :
    #         print(graph[i][j], end= " ")
    #     print()
    # print("graph===============")
total = 0
for i in range(R) :
    for j in range(C) :
        total += graph[i][j]
        #print(graph[i][j], end= " ")
    #print()
print(total+2)
 

