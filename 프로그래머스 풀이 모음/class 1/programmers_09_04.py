def solution(numbers):
    a = [0,1,2,3,4,5,6,7,8,9]
    total = sum(a)
    
    tmp = sum(numbers)
    
    
    answer = total - tmp
    return answer