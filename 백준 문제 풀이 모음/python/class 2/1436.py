n = int(input())

count = 0
x = 665
before = -1

while True :
    x = x + 1
    x_str = str(x)

    if '666' in x_str :
        count = count + 1

        if count == n :
            break
        
        before = x

print(x)

    
