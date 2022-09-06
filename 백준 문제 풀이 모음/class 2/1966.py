import sys

test_case = int(sys.stdin.readline())
for i in range(test_case) :
    n, m = map(int, sys.stdin.readline().split())
    imp = list(map(int, sys.stdin.readline().split()))
    idx = ['0'] * len(imp)
    idx[m] = '1'
    
    count = 0
    while True :
        if imp[0] == max(imp) :
            count += 1

            if idx[0] == '1' :
                print(count)
                break
            else :
                imp.pop(0)
                idx.pop(0)

        else :
            imp.append(imp.pop(0))
            idx.append(idx.pop(0))        
    




