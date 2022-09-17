import sys

N= int(sys.stdin.readline())
M = int(sys.stdin.readline())

S = list(sys.stdin.readline().rstrip())

i = 1
count = 0
succ = 0
while i < M-1 :
    if S[i-1] == 'I' and S[i] == 'O' and S[i+1] == 'I' :
        
           
        succ += 1
        
        if succ == N :
            succ -= 1
            count += 1     
        i += 2

    else :
        succ = 0
        i += 1
        

print(count)