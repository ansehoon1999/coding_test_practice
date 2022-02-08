import sys
input = sys.stdin.readline
n, m = map(int, input().split())
dic = {}
for i in range(n) :
    id, pwd = map(str, input().split())
    dic[id] = pwd

print(dic)
for i in range(m) :
    id = input().rstrip()
    print(dic.get(id))