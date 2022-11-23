
import sys
sys.setrecursionlimit(1000000)


n = int(sys.stdin.readline())

def factorial(n) :
    if n <= 1 :
        return 1
    return n * factorial(n-1)

count = 0

for i in range( n // 2 + 1) :
    len2 = i
    len1 = n - (2 * i)


   
    count += factorial(len2 + len1) // (factorial(len1) * factorial(len2))

print(count % 10007)










