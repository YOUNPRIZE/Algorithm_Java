N = int(input())

yaksu = list(map(int, input().split()))

answer = min(yaksu) * max(yaksu)

print(answer)