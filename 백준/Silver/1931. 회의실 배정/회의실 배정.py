# 백준 - 그리디
## 실버 1
### 회의실 배정

N = int(input())    
list = [list(map(int,input().split())) for _ in range(N)]
list.sort(key=lambda x:(x[1], x[0]))
cnt, end = 0, 0 
for i in range(len(list)):
    if i == 0:
        cnt += 1
        end = list[i][1]
    elif list[i][0] >= end:
        cnt += 1
        end = list[i][1]

print(cnt)