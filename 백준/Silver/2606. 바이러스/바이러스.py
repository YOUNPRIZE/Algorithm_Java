# 백준 - DFS, BFS
## 실버 3
### 바이러스

N = int(input())

C = int(input())

graph = [[0] * (N + 1)  for _ in range(N+1)]

visit = [0] * (N + 1)

for i in range(C):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

cnt = 0

def dfs(v):
    visit[v] = 1
    global cnt
    cnt += 1
    for i in range(1, N + 1):
        if visit[i] == 0 and graph[v][i] == 1:
            dfs(i)

dfs(1)

print(cnt-1)

