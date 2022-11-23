import sys

n = int(sys.stdin.readline())

class Node :
    def __init__(self, data, left, right) :
        self.data = data
        self.left = left
        self.right = right

tree = {}

for _ in range(n) :
    node, left, right = input().strip().split()
    tmp = Node(data = node, left = left, right = right)
    tree[node] = tmp


result1 = []

def pre_order(node) :
    result1.append(node)
    tmp = tree[node]

    if tmp.left != '.' :
        pre_order(tmp.left)
    if tmp.right != '.' :
        pre_order(tmp.right)

result2 = []

def in_order(node) :
    tmp = tree[node]
    if tmp.left != '.' :
        in_order(tmp.left)
    
    result2.append(node)
    if tmp.right != '.' :
        in_order (tmp.right)

result3 =[]

def post_order(node) :
    tmp = tree[node]
    if tmp.left != '.' :
        post_order(tmp.left)
    if tmp.right != '.' :
        post_order(tmp.right)
    result3.append(node)

pre_order('A')
print(''.join(result1))
in_order('A')
print(''.join(result2))
post_order('A')
print(''.join(result3))