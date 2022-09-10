import sys

input = sys.stdin.readline().rstrip()

op_list = []
new_input = ''
for i in range(len(input)) :
    if input[i] == '-'  :
        new_input += ' - '
    elif input[i] == '+' :
        new_input += ' + '
    else :
        new_input += input[i]

new_input = new_input.split(' ')
print(new_input)

