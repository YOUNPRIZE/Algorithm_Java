# 백준 - Greedy
## 골드 5
### 문자열 복사

import sys

input = sys.stdin.readline

S = input().strip()

P = input().strip()

string = ''

cnt = 0

for i in range(len(P)):
    string = string + P[i]
    if i == len(P) - 1:
        cnt += 1
        break
    elif string + P[i+1] in S:
        continue
    else:
        cnt += 1
        string = ''

print(cnt)