# 백준 - 그리디
## 골드 5
### 센서

import sys

input = sys.stdin.readline

N = int(input())

K = int(input())

sensor = list(map(int, input().split()))

sensor.sort()

array = []
for i in range(N-1):
    array.append(sensor[i+1]-sensor[i])

array.sort()

print(sum(array[:N-K]))