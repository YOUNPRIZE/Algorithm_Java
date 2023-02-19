import sys

sys.setrecursionlimit(10**6)
N, M, K = map(int, input().split())

graph = [[0] * (M) for _ in range(N)]

for i in range(K):
    x, y = map(int, input().split())
    graph[x-1][y-1] = 1

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def DFS(x, y):
    if x < 0 or x >= N or y < 0 or y >= M:
        return False

    if graph[x][y] == 1:
        global count
        count += 1
        graph[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            DFS(nx, ny)
        return True
    return False

count = 0
trash = []

for i in range(N):
    for j in range(M):
        if DFS(i, j) == True:
            trash.append(count)
            count = 0

print(max(trash))