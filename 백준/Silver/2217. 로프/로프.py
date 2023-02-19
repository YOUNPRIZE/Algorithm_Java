N = int(input())
ropes = []
for i in range(N):
    ropes.append(int(input()))

ropes.sort()
weight = []
for i in range(len(ropes)):
    weight.append(ropes[i] * (len(ropes) - i))

print(max(weight))