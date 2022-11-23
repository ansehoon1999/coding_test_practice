import sys
import heapq

def insert(min_list, max_list, list_dict, num) :
    heapq.heappush(min_list, num)
    heapq.heappush(max_list, (-num, num))
    if list_dict.get(num) == None :
        list_dict[num] = 1
    else :
        list_dict[num] += 1

def delete_min(min_list, list_dict) :
    while min_list :
        pop_item = heapq.heappop(min_list)
        if list_dict.get(pop_item) >0 :
            list_dict[pop_item] -= 1
            break

def delete_max (max_list, list_dict) :
    while max_list :
        pop_item =heapq.heappop(max_list)[1]
        if list_dict.get(pop_item) >0 :
            list_dict[pop_item] -=1
            break



t = int(sys.stdin.readline())

for i in range(t) :
    min_list = []
    max_list = []
    list_dict = {}

    k = int(sys.stdin.readline())

    for j in range(k) :
        command = sys.stdin.readline().rstrip()
        if command[0] == 'I' :
            insert(min_list, max_list, list_dict, int(command[2:]))

        elif command[0] == 'D' :
            if int(command[2: ]) == -1 :
                delete_min(min_list, list_dict)
            else :
                delete_max(max_list, list_dict)
    
    ans = [key for key, value in list_dict.items() if value > 0]
    if ans :
        ans.sort()
        print(ans[-1], ans[0])
    else :
        print("EMPTY")





