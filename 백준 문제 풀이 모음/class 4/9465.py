import sys
input = sys.stdin.readline
t = int(input())
for i in range(t) :
    n = int(input())
    tmp_list = []
    for j in range(2) :
        tmp = list(map(int, input().split()))
        tmp_list.append(tmp)

    for x in range(n) :
        if x == 0 :
            continue
        elif x ==1 :
            tmp_list[0][x] = tmp_list[0][x] + tmp_list[1][x-1]
            tmp_list[1][x] = tmp_list[1][x] + tmp_list[0][x-1]

            
        else :
            tmp_list[0][x] = max((tmp_list[0][x] + tmp_list[1][x-1]), tmp_list[0][x] + tmp_list[1][x-2])
            tmp_list[1][x] = max((tmp_list[1][x] + tmp_list[0][x-1]), tmp_list[1][x] + tmp_list[0][x-2])


    print(max(tmp_list[0][n-1], tmp_list[1][n-1]))

        



