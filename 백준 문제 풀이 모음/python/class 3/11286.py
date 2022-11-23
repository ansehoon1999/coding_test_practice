import sys
import heapq

N = int(sys.stdin.readline())

minus_hp = []
plus_hp = []

for _ in range(N) :
    tmp = int(sys.stdin.readline())
    
    if tmp < 0 :
        heapq.heappush(minus_hp, tmp * (-1))
    elif tmp > 0 :
        heapq.heappush(plus_hp, tmp) 
    
    else :
        if len(minus_hp) == 0 or len(plus_hp) == 0 :
            if len(minus_hp) == 0 and len(plus_hp) != 0 :
                print(heapq.heappop(plus_hp))
            elif len(minus_hp) != 0 and len(plus_hp) == 0 :
                print((-1) * heapq.heappop(minus_hp))
            elif len(minus_hp) == 0 and len(plus_hp) == 0 :
                print(0)
                
        else :
            if minus_hp[0] == plus_hp[0] :
                print((-1) * heapq.heappop(minus_hp))
            elif minus_hp[0] > plus_hp[0] :
                print(heapq.heappop(plus_hp))
            elif minus_hp[0] < plus_hp[0]:
                print((-1) * heapq.heappop(minus_hp))




    

    
