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


for i in range(1, len(new_input)-3, 2) :
    if new_input[i] == '-' :
        new_input[i+2] = '-'

count = int(new_input[0])
for i in range(1, len(new_input)-1, 2) :
    if new_input[i] == '-' :
        count -= int(new_input[i+1])
    elif new_input[i] == '+' :
        count += int(new_input[i+1])

print(count)



