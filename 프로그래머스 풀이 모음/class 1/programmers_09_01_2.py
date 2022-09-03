def solution(sizes):
    width = sizes[0][0]
    height = sizes[0][1]
    total = width * height
    
    for i in range(len(sizes))  :
        tmp1 = sizes[i][0]
        tmp2 = sizes[i][1]
        dict = {}
        
        if width >= tmp1 and height >= tmp2 :
            dict[width * height] = [width, height]
        elif width >= tmp1 and height < tmp2 :
            dict[width * tmp2] = [width, tmp2]
        elif width < tmp1 and height >= tmp2 :
            dict[tmp1 * height] = [tmp1, height]
        elif width < tmp1 and height < tmp2 :
            dict[tmp1 * tmp2] = [tmp1, tmp2]            

        
        if width >= tmp2 and height >= tmp1 :
            dict[width * height] = [width, height]            
        elif width >= tmp2 and height < tmp1 :
            dict[width * tmp1] = [width, tmp1]            
        elif width < tmp2 and height >= tmp1 :
            dict[tmp2 * height] = [tmp2, height]            
        elif width < tmp2 and height < tmp1 :
            dict[tmp2 * tmp1] = [tmp2, tmp1]            
        
        all_key = dict.keys()
        min_key = min(all_key)
        width = dict[min_key][0]
        height = dict[min_key][1]
        
    answer = width * height
    return answer