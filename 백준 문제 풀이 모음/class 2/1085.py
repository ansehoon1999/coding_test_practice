x, y, w, h = map(int, input().split())

l = [x, y, w-x, h-y]
print(min(l))