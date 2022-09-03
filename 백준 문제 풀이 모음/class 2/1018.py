n, m = map(int, input().split())
board = list()
for i in range(n) :
    board.append(input())

new = []

for i in range(0, n-8+1):   #row
    for j in range(0, m-8+1) : #column

        w_count = 0
        b_count = 0

        for ii in range(i, i+8) :
            for jj in range(j, j+8) :
        
                if (ii + jj) % 2 == 0 :
                    if board[ii][jj] != 'W' :
                        w_count += 1
                    elif board[ii][jj] != 'B' :
                        b_count += 1

                else :
                    if board[ii][jj] != 'W' :
                        b_count += 1
                    elif board[ii][jj] != 'B' :
                        w_count += 1      
        
        new.append(b_count)
        new.append(w_count)

print(min(new))


