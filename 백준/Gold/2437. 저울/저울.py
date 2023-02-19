# 백준 - Greedy
## 골드 2
### 저울

import sys

input = sys.stdin.readline

N = int(input())

W = list(map(int, input().split()))

W.sort()

target = 1
for i in W:
    if target < i:
        break
    target += i

print(target)