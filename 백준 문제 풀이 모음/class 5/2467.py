import sys
input = sys.stdin.readline

N = int(input())

arr = list(map(int, input().split()))
start = -1
end = -1
if arr[0] <= 0 and arr[-1] <= 0 :
    print(arr[-2], arr[-1])
elif arr[0] >= 0 and arr[-1] >= 0 :
    print(arr[0], arr[1])
else :
    answerL = 0
    answerR = 0
    front = 0
    before = N-1
    _min = sys.maxsize
    while front < before :
        _sum = arr[front] + arr[before]

        if abs(_sum) < _min  :
            answerL = front
            answerR = before

            _min = abs(_sum)

        if _sum > 0 :
            before -= 1
        elif _sum < 0 :
            front += 1
        else :
            break
            
    print(arr[answerL], arr[answerR])
    # if ( start + end ) * (-1) < minn :
