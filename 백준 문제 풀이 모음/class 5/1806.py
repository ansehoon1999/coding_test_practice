

import sys
input = sys.stdin.readline

N, S = map(int, input().split())
arr = list(map(int, input().split()))

interval_sum = 0

end = 0
minn = 10000000

for start in range(N) :
    while interval_sum < S and end < N :
        interval_sum += arr[end]
        end += 1

    if interval_sum >= S :
        if minn > (end-start) :
            minn = end-start
    interval_sum -= arr[start]
if minn == 10000000 :
    print(0)
else :
    print(minn)
# for start in range(N) :
#     while interval_sum < S and end < N :
#         interval_sum += arr[end]
#         end += 1

#     if interval_sum >= S :
#         if minn > (end - start) :
#             minn = (end-start)
#     interval_sum  -= arr[start]

# if  minn == 10000000 :
#     print(0)
# else :
#     print(minn)
