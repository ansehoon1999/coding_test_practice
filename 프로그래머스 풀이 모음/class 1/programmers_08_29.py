def solution(survey, choices):
    dict = {
        'R': 0, 
        'T': 0,
        'C': 0,
        'F': 0,
        'J': 0,
        'M': 0,
        'A': 0,
        'N': 0
    }
    
    for i in range(len(survey)) :
        survey_tmp = survey[i]
        survey_each = list(survey_tmp)
        print(survey_each)
        choice_tmp = choices[i] - 4
        
        if choice_tmp > 0 :
            
            types = survey_each[1]
            cost = choice_tmp
            dict[types] = dict[types] + cost
        elif choice_tmp < 0 :
            types = survey_each[0]
            cost = choice_tmp * (-1)
            dict[types] = dict[types] + cost
        else :
            continue
    answer = ''
    if dict['R'] >= dict['T'] :
        answer = answer + 'R'
    elif dict['R'] < dict['T'] :
        answer = answer + 'T'
        
    if dict['C'] >= dict['F'] :
        answer = answer + 'C'
    elif dict['C'] < dict['F'] :
        answer = answer + 'F'
        
    if dict['J'] >= dict['M'] :
        answer = answer + 'J'
    elif dict['J'] < dict['M'] :
        answer = answer + 'M'

    if dict['A'] >= dict['N'] :
        answer = answer + 'A'
    elif dict['A'] < dict['N'] :
        answer = answer + 'N'
        
    return answer