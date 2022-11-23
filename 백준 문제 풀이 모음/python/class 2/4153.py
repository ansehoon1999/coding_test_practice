
while True:
    a = list(map(int, input().split()))
    m = max(a)

    if sum(a) == 0 :
        break

    a.remove(m)

    if a[0] ** 2 + a[1] ** 2 == m ** 2 :
        print('right')

    else :
        print('wrong')