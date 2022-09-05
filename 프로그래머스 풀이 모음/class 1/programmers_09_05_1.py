def solution(absolutes, signs):
    plus = 0
    minus = 0
    for i in range(len(signs)) :
        if signs[i] :
            plus += absolutes[i]
        else :
            minus += absolutes[i]
    
    
    answer = plus - minus
    return answer