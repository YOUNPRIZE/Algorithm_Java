# 백준 - DFS, BFS
## 실버 2
### A -> B

from collections import deque

a, b = map(int, input().split())

res = -1

queue = deque([(a, 1)])

while queue:
    i, cnt = queue.popleft()
    if i == b:
        res = cnt
        break
    
    if i * 2 <= b:
        queue.append((i*2, cnt+1))
    if int(str(i) + '1') <= b:
        queue.append((int(str(i) + '1'), cnt+1))

print(res)