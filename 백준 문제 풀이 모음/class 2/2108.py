import sys

N = int(sys.stdin.readline())
li = []
for _ in range(N) :
    li.append(int(sys.stdin.readline()))
li = sorted(li)

#1
print(round(sum(li)/N))
#2
center = int(N / 2) 
print(li[center])

#3
dict = {}

for i in li :
    if i not in dict :
        dict[i] = 1
    else :
        dict[i] += 1

most = max(dict.values())
max_list = []
for key, value in dict.items() :
    if value == most :
        max_list.append(key)

if len(max_list) >= 2 :
    print(max_list[1])
else :
    print(max_list[0])

#4
print(li[-1] - li[0])