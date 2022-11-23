
import sys
n = int(input())
a = sys.stdin.readline().split()
a.sort()

m = int(input())
x = sys.stdin.readline().split()

def binary_serach(arr, value) :
    first, last = 0, len(arr) -1

    while first <= last :
        mid = (first + last) // 2

        if value < arr[mid]  :
            last = mid -1
        elif value > arr[mid] :
            first = mid + 1
        
        elif value == arr[mid] :
            return True
    
    return False

for i in x :
    if binary_serach(a, i) :
        print(1)
    else :
        print(0)
