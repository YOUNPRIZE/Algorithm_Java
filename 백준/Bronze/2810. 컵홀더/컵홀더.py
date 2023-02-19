# 백준 - 그리디
## 브론즈 1
### 컵홀더

N = int(input())
seat = input()

seat = seat.replace('S', '*S*')
seat = seat.replace('LL', '*LL*')
seat = seat.replace('**', '*')

if seat.count('*') > N:
    print(N)
else:
    print(seat.count('*'))