import sys

N = int(sys.stdin.readline())
state = False

count = 0

first = 2
first_count = 2
second = 8
second_count = 3

while True :
    if state :
        break

    if N == 1 :
        count += 1
        break

    elif first <= N < second :
        count = first_count
        state = True
    
    else :
        first = first + (first_count-1) * 6
        second = second + (second_count-1) *6
        first_count += 1
        second_count += 1

        


print(count)