

import sys
n, r, c = map(int, sys.stdin.readline().split())
result = 0


while n != 0 :
    n -= 1

    if r < 2** n  and c < 2 ** n : # 1사분면
        result += (2 ** n) * (2 ** n ) * 0

    elif r < 2** n  and c >= 2 ** n : # 2사분면 
        result += (2 ** n) * (2 ** n ) * 1
        c -= (2 ** n)

    elif r >= 2** n  and c < 2 ** n : # 3사분면 
        result += (2 ** n) * (2 ** n ) * 2
        r -= (2**n)

    else : # 4사분면 
        result += (2 ** n) * (2 ** n ) * 3
        c -= (2 ** n)
        r -= (2**n)

print(result)