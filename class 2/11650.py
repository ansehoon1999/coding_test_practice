

num = int(input())

lst = []

for i in range(num) :
    x, y = map(int, input().split())
    lst.append([x,y])


lst.sort(key=lambda x:x[1])
lst.sort(key=lambda x:x[0])

for i in range(len(lst)) :
    print(lst[i][0], end = ' ')
    print(lst[i][1])


