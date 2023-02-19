N, K = map(int, input().split())
money = []
cnt = 0
for i in range(N):
    money.append(int(input()))

money.sort(reverse=True)

for i in money:
    if K == 0:
        break
    elif K // i > 0:
        share = K // i
        K -= (K // i) * i
        cnt += share

print(cnt)