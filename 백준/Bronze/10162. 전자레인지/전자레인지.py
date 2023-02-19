N = int(input())

cntA = 0
cntB = 0
cntC = 0
error = 0

while N > 0:
    if N >= 300:
        cntA += N // 300
        N -= (N // 300) * 300
    elif N >= 60:
        cntB += N // 60
        N -= (N // 60) * 60
    elif N >= 10:
        cntC += N // 10
        N -= (N // 10) * 10
    else:
        error += 1
        break

if error == 1:
    print(-1)
else:
    print(cntA, cntB, cntC)
        