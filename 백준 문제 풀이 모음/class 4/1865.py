import sys
input = sys.stdin.readline
INF = sys.maxsize
TC = int(input())

# 벨만 포드 알고리즘 응용 -> 그래프상 음의 싸이클 존재 판단 함수
def bellman_ford(start):
    dis = [INF] * (n+1)  # 최단거리 초기화
    dis[start]=0
    # 메인 로직
    # 음의 사이클 판별을 위해 n번 반복
    for i in range(n):
        # 반복마다 모든 간선 확인
        for edge in edges:
            cur = edge[0] # 출발
            next_node = edge[1] # 도착
            cost = edge[2] # 비용

            
            # 다음 노드로 이동하는 거리가 최단거리로 갱신가능한 경우
            if dis[next_node] > cost + dis[cur]:
                dis[next_node] = cost + dis[cur]
                # i==n-1이면 n번 돌린건데 이때도 갱신이 발생하면 음의 싸이클 존재
                if i == n - 1:
                    return True

    return False



for _ in range(TC) :
    n, m, w = map(int, input().split())
    edges = []
    for _ in range(m) :
        s, e, t = map(int, input().split())
        edges.append((s, e, t))
        edges.append((e, s, t))
    
    for _ in range(w) :
        s, e, t = map(int, input().split())
        edges.append((s,e,t * (-1)))
    
    
    key = bellman_ford(1)
    if key:
        print("YES")
    else:
        print("NO")

