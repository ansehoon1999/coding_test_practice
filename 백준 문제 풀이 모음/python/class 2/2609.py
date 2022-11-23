


a, b = map(int, input().split())

def gcd(x, y) :
    while(y) :
        x, y = y, x%y
    return x

def lcm(x, y) :
    result = (x*y) // gcd(x, y)
    return result

print(gcd(a, b))
print(lcm(a, b))
