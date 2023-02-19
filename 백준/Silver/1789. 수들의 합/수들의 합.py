# 백준 - 그리디
## 실버 5
### 수들의 합

S = int(input())

sum = 0

N = 0

for i in range(1, S+1):
    sum+=i
    N+=1
    if sum > S:
        N-=1
        break
print(N)