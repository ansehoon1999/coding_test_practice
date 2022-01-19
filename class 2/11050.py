
def binomial(n, k) :
    if k==0 or n== k :
        return 1

    


    return binomial(n-1, k) + binomial(n-1, k-1)

n, k = map(int, input().split())

print(binomial(n,k))