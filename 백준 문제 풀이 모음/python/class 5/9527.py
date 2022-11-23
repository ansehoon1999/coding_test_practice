# import sys
# input = sys.stdin.readline

# a, b = map(int, input().split())

# graph = [0] * (b+1)
# graph[0] = 0
# graph[1] = 1

# first = 1
# second = 2

# for num in range(2, b+1) :
#     if 2 ** first <= num < 2 ** second :
#         graph[num] = graph[num - 2 ** first] + 1
#     else :
#         first += 1
#         second += 1
#         graph[num] = graph[num - 2 ** first] + 1

# sum = 0
# for i in range(a, b+1) :
#     sum += graph[i]
# print(sum)
 

from itertools import count


a, b = map(int, input().split())
psum = [0 for x in range(60)]

for i in range(1, 60) :
    psum[i] = 2 ** (i-1) + 2 * psum[i-1]

def check(num) :
    count = 0
    bin_num = bin(num)[2:]
    length = len(bin_num)

    for i in range(length) :
        if bin_num[i] == '1' :
            pow = length - i - 1
            count += psum[pow]

            count += num - 2 ** pow + 1
            num = num - 2 ** pow
    return count

 
print(check(b) - check(a-1))