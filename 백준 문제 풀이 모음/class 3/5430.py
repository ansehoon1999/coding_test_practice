from collections import deque

T = int(input())
for _ in range(T) :
    p = input()
    n = int(input())
    if n :
        que = deque(input().strip('[]').split(','))
    else :
        input()
        que = deque()
        
    rev, flag =0, 0
    for i in range(len(p)) :
        if p[i] == 'R' :
            rev += 1
        elif p[i] == 'D' :
            if len(que) == 0 :
                flag = 1
                print('error')
                break
            else :
                if rev %2 == 0 :
                    que.popleft()
                else :
                    que.pop()
    if flag == 0 :
        if rev % 2 == 0 :
            print('[' + ','.join(que) + ']')
        else :
            que.reverse()
            print('[' + ','.join(que) + ']')