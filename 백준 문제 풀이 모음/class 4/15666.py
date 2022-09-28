import sys
input = sys.stdin.readline

n, m = map(int, input().split())

tmp = list(map(int, input().split()))
tmp = sorted(list(set(tmp)))


from itertools import product

li = []
for per in product(tmp, repeat = m) :
    per = sorted(per)
    if per not in li :
        li.append(per)
    
        per = str(per).replace(']', '').replace('[', '').replace(',', '')
        print(per)

    
