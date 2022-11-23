import sys

N = int(sys.stdin.readline())
num_list = [0] * 10001

for i in range(N) :
    tmp = int(sys.stdin.readline())
    num_list[tmp] += 1

for i in range(1, len(num_list)) :
    for j in range(num_list[i]) :
        print(i)
