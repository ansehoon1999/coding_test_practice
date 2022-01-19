import sys

def quad_tree(x, y, n ):
    global blue, white, array
    color = array[y][x]
    state = False

    for i in range(x, x+n):
        if state :
            break

        for j in range(y, y+n):
            
            if color != array[j][i] : 
                quad_tree(x, y, n//2)
                quad_tree(x + n//2, y + n//2, n//2)
                quad_tree(x+ n//2 , y, n//2 )
                quad_tree(x, y+n//2, n//2)
                state = True 
                break

    if not state :
        if array[y][x] == 1:
            blue = blue + 1
        else :
            white = white  +1

    
blue = 0
white = 0
array = []
n = int(input())
for _ in range(n) :
    array.append(list(map(int, input().split())))

quad_tree(0,0,n)
print(white)
print(blue)
