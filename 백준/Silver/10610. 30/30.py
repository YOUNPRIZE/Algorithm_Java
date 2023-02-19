# 백준 - Greedy
## 실버 4
### 30

N = int(input())

sum = 0
string = ''

if '0' not in str(N):
    print(-1)
else:
    N = list(str(N))
    for i in N:
        sum += int(i)
    
    if sum % 3 !=0:
        print(-1)
    else:
        N.sort(reverse=True)
        for i in N:
            string = string + i
        print(int(string))
