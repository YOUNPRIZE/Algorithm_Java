# 백준 - Greedy
## 실버 1
### 흙길 보수하기

import sys

input = sys.stdin.readline

N, L = map(int, input().split())

pool = [list(map(int, input().split())) for _ in range(N)]

pool.sort(key=lambda x : x[0])

plank = 0

total_count = 0

for start, end in pool:
    if plank > end:
        continue
    elif plank < start:
        plank = start
    dist = end - plank
    remainder = 1
    if dist % L == 0:
        remainder = 0
    cnt = dist // L + remainder
    plank += cnt * L
    total_count += cnt
print(total_count)