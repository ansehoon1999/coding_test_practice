from operator import truediv
import sys

input = sys.stdin.readline
INF = sys.maxsize

TC = int(input())

def bellman_ford(start) :
    distance = [INF] * (n+1)
    distance[start] = 0

    for i in range(n) :
        for edge in edges :
            curr_node = edge[0]
            next_node = edge[1]
            edge_cost = edge[2]
        
            if   distance[next_node] > distance[curr_node] + edge_cost :
                distance[next_node] = distance[curr_node] + edge_cost
                if i == n-1 :
                    return True
    return False


for _ in range(TC) :
    n,m,w = map(int, input().split())
    edges = []
    for i in range(m) :
        s,e,t = map(int, input().split())
        edges.append((s,e,t))
        edges.append((e,s,t))
    
    for _ in range(w) :
        s,e,t = map(int, input().split())
        edges.append((s,e,-t))
    
    key = bellman_ford(1)
    if key :
        print('YES')
    else :
        print('NO')
