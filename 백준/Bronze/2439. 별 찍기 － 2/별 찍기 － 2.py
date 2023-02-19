import sys

N = int(sys.stdin.readline())

star = "*"
blank = " "

for i in range(1, N+1):
    answer = blank * (N - i) + star * i
    print(answer)