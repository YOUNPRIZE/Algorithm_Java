import sys
input = sys.stdin.readline
n=int(input())
maps = [list(map(int,input().split())) for _ in range(2)]

sum = 0

maps[0].sort()
maps[1].sort(reverse=True)

for i in range(len(maps[0])):
    sum += maps[0][i] * maps[1][i]
print(sum)