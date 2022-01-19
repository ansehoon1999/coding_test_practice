
def is_prime_num(x) :
    if x == 1 :
        return False

    for i in range(2, int(math.sqrt(x)) + 1) :
        if x % i == 0 :
            return False
        
    return True


import math

num = int(input())
str = input()
str = str.split(" ")
count = 0

for i in range(num) :
    if is_prime_num(int(str[i])) :
        count = count + 1
    
print(count)