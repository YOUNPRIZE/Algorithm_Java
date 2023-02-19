# 백준 - 그리디
## 실버 3
### 주유소

import sys
input = sys.stdin.readline
N = int(input())
distance = list(map(int,input().split()))
price = list(map(int,input().split()))
lowPrice = 0
total = 0
for i in range(len(price)):
    if i == 0:
        total += price[i] * distance[i]
        lowPrice = price[i]
    elif i == len(price) - 1:
        break
    elif lowPrice > price[i]:
        lowPrice = price[i]
        total += lowPrice * distance[i]
    else:
        total += lowPrice * distance[i]

print(total)

