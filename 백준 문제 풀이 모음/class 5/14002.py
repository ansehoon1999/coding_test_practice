import sys
input = sys.stdin.readline

N = int(input())
A = [*map(int, input().split())]

LIS = [str(A[0])]


def findPlace(e) :
    start = 0
    end = len(LIS) - 1

    while start <= end :
        mid = (start + end) // 2

        if int(LIS[mid]) == e :
            return mid
        elif int(LIS[mid])  < e :
            start = mid + 1
        else :
            end = mid - 1
    return start

for item in A :
    if int(LIS[-1]) < item :
        LIS.append(str(item))
    else :
        idx = findPlace(item)
        LIS[idx] = str(item)

print(len(LIS))
print(' '.join(LIS))
