import sys
inputv = sys.stdin.readline
string_a = ' ' + input().rstrip()
string_b = ' ' + input().rstrip()

dp = [[0] * len(string_b) for _ in range(len(string_a))]
dp2 = [[""] * len(string_b) for _ in range(len(string_a))]

for i in range(1, len(string_a)) :
    for j in range(1, len(string_b)) :
        if string_a[i] == string_b[j] :
            dp[i][j] = dp[i-1][j-1] + 1
            dp2[i][j] = dp2[i-1][j-1] + string_b[j]
        else :
            dp[i][j]  = max(dp[i-1][j], dp[i][j-1])
            if dp[i-1][j] > dp[i][j-1] :
                dp2[i][j] = dp2[i-1][j]
            else :
                dp2[i][j] = dp2[i][j-1]

print(dp[-1][-1])
print(dp2[-1][-1])
# for i in range(len(string_a)) :
#     for j in range(len(string_b)) :
#         print(dp[i][j], end = " ")
#     print()

# for i in range(len(string_a)) :
#     for j in range(len(string_b)) :
#         print(dp2[i][j], end = " ")
#     print()