import sys
input = sys.stdin.readline
MOD = 1000000007

mm = {}
n, m = map(int, input().split())
mm[1] = []
for i in range(n) :
    tmp = [0] * n
    mm[1].append(tmp)

for i in range(m) :
    frm, to = map(int, input().split())
    mm[1][frm-1][to-1] = 1

num = int(input())

print(mm)
def f (d, frm, to) :
    if d <= 1 :
        return mm[d][frm][to]

    mm.setdefault(d, [[0 for _ in range(n)] for _ in range(n)])
    if mm[d][frm][to] :
        return mm[d][frm][to]
    
    half = d // 2
    other = half + 1 if d % 2 else half

    for k in range(n) :
        mm[d][frm][to] += f (half, frm, k) * f(other, k, to)
        mm[d][frm][to] %= MOD

    return mm[d][frm][to]
print(f(num, 0, 0))
