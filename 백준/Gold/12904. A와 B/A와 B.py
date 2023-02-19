# 백준 - 그리디
## 골드 5
### A와 B

import sys

input = sys.stdin.readline

S = list(input().rstrip())
T = list(input().rstrip())

button = False
while T:
    if T[-1] == 'A':
        T.pop()
    else:
        T.pop()
        T.reverse()
    if S == T:
        button = True
        break
    
if button:
    print(1)
else:
    print(0)