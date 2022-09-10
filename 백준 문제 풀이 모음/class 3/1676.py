import sys

def factorial(n) :
    if(n > 1) :
        return n * factorial(n-1)
    else :
        return 1


N = int(sys.stdin.readline())
tmp = factorial(N)
count = 0
while True :
    if tmp % 10 == 0 :
        count += 1
        tmp = tmp // 10
    else :
        break

print(count)

