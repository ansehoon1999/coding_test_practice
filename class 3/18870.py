
import sys

x = int(sys.stdin.readline())



arr = list(map(int, sys.stdin.readline().split()))

tmp = []
arr2 = list(set(arr))
arr2.sort()


dic = {arr2[i] : i for i in range(len(arr2))}

for i in arr :
    print(dic[i], end= " ")