import sys
input = sys.stdin.readline

N = int(input())
A = [*map(int, input().split())]

LIS = [A[0]]


def findPlace(e) :
    start = 0
    end = len(LIS) - 1

    while start <= end :
        mid = (start + end) // 2

        if LIS[mid] == e :
            return mid
        elif LIS[mid] < e :
            start = mid + 1
        else :
            end = mid - 1
    return start

for item in A :
    if LIS[-1] < item :
        LIS.append(item)
    else :
        idx = findPlace(item)
        LIS[idx] = item

print(len(LIS))