n = int(input())

for i in range(n) :
    h, w, n = map(int, input().split())
    front = n % h
    

    back = (n // h) + 1

    if front == 0 :
        front = h
        back = back -1

    if back < 10 :
        print(int(str(front) + '0' + str(back)))
    else :
        print(int(str(front) + str(back)))
    

