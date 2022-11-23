import sys
import operator as op
from functools import reduce

n = int(sys.stdin.readline())

def nCr(n, r):
    if n < 1 or r < 0 or n < r:
        raise ValueError
    r = min(r, n-r)
    numerator = reduce(op.mul, range(n, n-r, -1), 1)
    denominator = reduce(op.mul, range(1, r+1), 1)
    return numerator // denominator


num2 = n // 2
num1 = n - (num2 * 2)

result = 0
if num2 == 0 :
    result = 1
else :
    while True :
        if num2 == -1 :
            break

        first = 2 ** num2
        second = nCr((num2+num1), num2)
        result += first * second

        num2 = num2 - 1
        num1 = num1 + 2


print(result % 10007)
