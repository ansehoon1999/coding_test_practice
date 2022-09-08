import sys

N = int(sys.stdin.readline())

a5 = int(N/5)
count = 0
while True :
    a3 = N - (a5 * 5)
    
    if a3 % 3 == 0 and a5 >= 0:
        a3 = a3 / 3
        count = a5 + a3
        break
    elif a5 < 0 :
        count = -1
        break
    else :
        a5 -= 1

print(int(count))