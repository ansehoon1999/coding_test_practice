import sys

n, m = map(int, sys.stdin.readline().split())

x = []
y = []

for i in range(n) :
    tmp = sys.stdin.readline().rstrip()
    x.append(tmp)

for i in range(m) :
    tmp = sys.stdin.readline().rstrip()
    y.append(tmp)

intersection = list(set(x).intersection(y))
intersection.sort()
print(len(intersection))
for i in intersection :
    print(i)

