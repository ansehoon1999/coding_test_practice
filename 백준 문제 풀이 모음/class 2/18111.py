import sys

N, M, B = map(int, sys.stdin.readline().split())
block = []

for i in range(N) :
    tmp = list(map(int, sys.stdin.readline().rstrip().split()))
    block.append(tmp)
    
    



ans = int(1e9)
floor = 0

for i in range(257) :

    use_block = 0
    take_block = 0
    for x in block :
        for tmp in x :
            if  tmp > i :
                take_block += tmp - i
            elif tmp < i :
                use_block += i - tmp

    if use_block > take_block  + B :
        continue
    
    count = use_block  + take_block * 2
    if ans >= count :
        ans = count
        floor = i

print(ans, floor)




