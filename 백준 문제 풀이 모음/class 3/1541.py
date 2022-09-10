import sys

input = sys.stdin.readline().rstrip()

op_list = []
for i in input :
    if i == '-' or i == '+' :
        op_list.append(i)
        
print(op_list)

input = input.replace("-", " ").replace("+", " ").split(" ")
print(input)


