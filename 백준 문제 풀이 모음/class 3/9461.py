import sys

n = int(sys.stdin.readline())


for _ in range(n) :
    x = int(sys.stdin.readline())
    
    

    if x <= 4 :
        result = [0,1,1,1,2]
        print(result[x])
    else :
        result = [0] * (x+1)
        result[1] = 1
        result[2] = 1
        result[3] = 1
        result[4] = 2
        for i in range(5, x+1) :
            result[i] = result[i-1] + result[i-5] 

        print(result[x])