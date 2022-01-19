import sys

k, n = map(int, input().split())

l = []
for i in range(k) :
    x = int(sys.stdin.readline())
    l.append(x)

start = 1
end = max(l)

while start <= end :
    

    mid = (start + end) // 2
    line = 0

    for i in l :
        line = line + (i // mid)

    if line >= n :
        start = mid + 1

    else :
        end = mid - 1

print(end)