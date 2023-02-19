# 백준 다이나믹 프로그래밍
## 점프

import sys

N = int(sys.stdin.readline())

board = []

for i in range(N):
    temp = (list(map(int, sys.stdin.readline().split())))
    board.append(temp)

dp = []
for i in range(N):
    dp.append([])
    for j in range(N):
        dp[i].append(0)

dp[0][0] = 1

dp[0][0] = 1
for i in range(N):
    for j in range(N):
        if i==N-1 and j==N-1:
            break
        value = board[i][j]
        down = i + value
        right = j + value

        if down < N:
            dp[down][j] += dp[i][j]
        if right < N:
            dp[i][right] += dp[i][j]

print(dp[N-1][N-1])
