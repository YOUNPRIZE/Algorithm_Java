# 백준 다이나믹 프로그래밍
## 퇴사 2

import sys

N = int(sys.stdin.readline())

day = N
t, p = [], []
dp = [0]*(N+1)

for i in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    t.append(temp[0])
    p.append(temp[1])

for i in range(0, N):
    # t[i+1]번째 상담을 완료하는데 걸리는 시간이 남은 N일에서 i를 뺀 값보다 작거나 같다면
    # 
    if t[i] <= N - i:
        dp[i+t[i]] = max(dp[i+t[i]], dp[i]+p[i])
        
    dp[i+1] = max(dp[i+1], dp[i])

print(dp[N])