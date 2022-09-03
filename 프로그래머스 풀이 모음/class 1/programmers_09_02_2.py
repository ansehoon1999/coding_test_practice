def solution(numbers, hand):
    dict = {
        '1': [0,0],
        '2': [0,1],
        '3': [0,2],
        '4': [1,0],
        '5': [1,1],
        '6': [1,2],
        '7': [2,0],
        '8': [2,1],
        '9': [2,2],
        '*': [3,0],
        '0': [3,1],
        '#': [3,2]
    }
    
    left = dict['*']
    right = dict['#']
    answer = ''
    for i in numbers :
        
        if i == 1 or i == 4 or i == 7 :
            answer += "L"
            left = dict[str(i)]
        elif i == 3 or i == 6 or i == 9 :
            answer += "R"
            right = dict[str(i)]
        elif i == 2 or i == 5 or i == 8 or i == 0 :
            current = dict[str(i)]
            l_dist = abs(current[0] - left[0]) + abs(current[1] - left[1])
            r_dist = abs(current[0] - right[0]) + abs(current[1] - right[1])
            
            if l_dist < r_dist :
                answer += "L"
                left = dict[str(i)]
            elif l_dist > r_dist :
                answer += "R"
                right = dict[str(i)]
            elif l_dist == r_dist :
                if hand == "left" :
                    answer += "L"
                    left = dict[str(i)]
                elif hand == "right" :
                    answer += "R"
                    right = dict[str(i)]

    
    return answer