
x = input()
x_num = int(x)
min = 10000000

for i in range(x_num, 1, -1) :
    total = 0
    l = list(str(i))
    total = total + i
    for j in range(len(l)) :
        total = total + int(l[j])

    if total == x_num :
        min = i
    
if min == 10000000 :
    print(0)
else :
    print(min)



    






