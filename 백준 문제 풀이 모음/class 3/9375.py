import sys
from collections import Counter
test_case = int(sys.stdin.readline())
for _ in range(test_case) :
    n = int(sys.stdin.readline())
    num1 = []
    num2 = []
    count = 0
    for i in range(n) :
        a, b = map(str, sys.stdin.readline().split())
        num2.append(b)
        if b not in num1 :
           num1.append(b) 
        x = Counter(num2)
    tmp =1 
    for i in num1 :
        tmp *= (x[i] +1)
    print(tmp-1)


        
       
        
