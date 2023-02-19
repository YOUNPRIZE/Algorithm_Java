# 백준 - Greedy
## 실버 5
### 뒤집기

S = input()

cnt = 0

comp = 'x'

for i in S:
    if i != comp:
        comp = i
        cnt += 1
        
print((cnt)//2)