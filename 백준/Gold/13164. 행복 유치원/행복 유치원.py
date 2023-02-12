N, K = map(int, input().split())
child = list(map(int, input().split()))

array = []
for i in range(1, N):
    array.append(child[i] - child[i-1])

array.sort(reverse=True)

print(sum(array[K-1:]))