import sys, copy
input = sys.stdin.readline

n = int(input())
graph1 = [0,0,0]
graph2 = [0,0,0]


for _ in range(n) :
    a,b,c = map(int, input().split())

    first1 = max(a + graph1[0], a + graph1[1])
    second1 = max(b + graph1[0], b + graph1[1], b + graph1[2])
    third1 = max(c + graph1[1], c + graph1[2])

    graph1[0] = first1
    graph1[1] = second1
    graph1[2] = third1

    first2 = min(a + graph2[0], a + graph2[1])
    second2 = min(b+ graph2[0], b + graph2[1], b + graph2[2])
    third2 = min(c + graph2[1], c + graph2[2])

    graph2[0] = first2
    graph2[1] = second2
    graph2[2] = third2 



print(max(graph1))
print(min(graph2))