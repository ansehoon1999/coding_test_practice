def solution(board, moves):
    new_board = []
    result = []
    for i in range(len(board)) :
        new_board.append([])
    
    for i in range(len(board)) :
        for j in range(len(board)) :
            if board[j][i] != 0 :
                new_board[i].append(board[j][i])
    count = 0
    for i in moves :
        if len(new_board[i-1]) == 0 :
            continue
        else : 
            tmp = new_board[i-1].pop(0)
            result.append(tmp)
        
        while True :
            if len(result) < 2 :
                break
            
            else :
                if result[-1] == result[-2] :
                    count += 2
                    result.pop(-1)
                    result.pop(-1)
                else :
                    break
        
                    
    
    
    return count