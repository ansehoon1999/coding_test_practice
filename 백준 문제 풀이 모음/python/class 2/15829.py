import sys

L = int(sys.stdin.readline())
M = 1234567891
r = 31


input = list(sys.stdin.readline().rstrip())

count = 0
for i in range(len(input)) :
    num = ord(input[i]) - 96
    count += num * (r**i)
print(count % M)  

