def solution(arr):
    answer = []
    answer.append(arr[0])
    
    tmp = arr[0]
    for i in range(1, len(arr)) :
    
        
        if tmp == arr[i] :
            tmp = arr[i]        
            continue
        else :
            answer.append(arr[i])
            tmp = arr[i]
        

    return answer