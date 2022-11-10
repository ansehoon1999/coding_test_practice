import sys
input = sys.stdin.readline
from itertools import combinations
from collections import defaultdict
n, s = map(int, input().split())
arr = list(map(int, input().split()))


def get_sub_sum(arr : list, result : defaultdict) :
    for count in range(1, len(arr) + 1) :
        for combi in combinations(arr, count) :
            c_sum = sum(combi)
            result[c_sum] += 1

sub_sum1 = defaultdict(int)
sub_sum2 = defaultdict(int)

get_sub_sum(arr[n//2 : ], sub_sum1)
get_sub_sum(arr[: n//2], sub_sum2)

answer = sub_sum1[s] + sub_sum2[s] 

for x in sub_sum1 :
    if s-x in sub_sum2 :
        answer += sub_sum1[x] * sub_sum2[s-x]

print(answer)

