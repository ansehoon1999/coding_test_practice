import sys

n = int(sys.stdin.readline()) 
result = []
for i in range(n) :
    tmp = list(map(int, sys.stdin.readline().split()))

    if i == 0 :
        result = tmp
    
    else :
        length = len(tmp)

        for j in range(length) :
            if j == 0 :
                tmp[j] = tmp[j] + result[0] 

            elif j == length -1 :
                tmp[j] = tmp[j] + result[-1]
            
            else :

                tmp[j] = max(tmp[j] + result[j], tmp[j] + result[j-1])
        
        result = tmp

print(max(result))