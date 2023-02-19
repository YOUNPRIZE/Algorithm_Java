# 백준 - 그리디
## 브론즈 2
### 거스름돈

import sys
input = sys.stdin.readline

N = int(input())
money = [500, 100, 50, 10, 5, 1]
change = 1000 - N
cnt = 0
for i in money:
    if change // i > 0:
        cnt += change // i
        change -= (change // i) * i
    elif change == 0:
        break

print(cnt)
