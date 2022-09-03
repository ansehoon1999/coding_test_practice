def solution(id_list, report, k):
    report = list(set(report))
    dict = {}
    
    for i in report :
        tmp = i.split(" ")
        
        if dict.get(tmp[1]) :
            dict[tmp[1]].append(tmp[0])
        else :
            dict[tmp[1]] = [tmp[0]]       
    
    dict2 = {}
    for key, value in dict.items() :
        if len(value) >= k :
            for i in value :
                if dict2.get(i) :
                    dict2[i] += 1
                else :
                    dict2[i] = 1
    
    answer = []
    for i in id_list :
        if dict2.get(i) :
            answer.append(dict2[i])
        else :
            answer.append(0)

    
    
    return answer