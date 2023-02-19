# 백준 - Greedy
## 브론즈 3
### 세탁소 사장 동혁

T = int(input())

for _ in range(T):
    N = int(input())
    
    cntA, cntB, cntC, cntD = 0, 0, 0, 0

    while N > 0:
        if N >= 25:
            cntA += N // 25
            N -= (N // 25) * 25
        elif N >= 10:
            cntB += N // 10
            N -= (N // 10) * 10
        elif N >= 5:
            cntC += N // 5
            N -= (N // 5) * 5
        else:
            cntD += N // 1
            N -= (N // 1) * 1
    
    print(cntA, cntB, cntC, cntD)
