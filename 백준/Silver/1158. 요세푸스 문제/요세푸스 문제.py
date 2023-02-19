from collections import deque

n, m = map(int, input().split())

ppl = deque()
answer = []

for i in range(1, n+1):
    ppl.append(i)

while ppl:
    for _ in range(m-1):
        num = ppl.popleft()
        ppl.append(num)
    numb = ppl.popleft()
    answer.append(numb)

print("<", ', '.join(str(i) for i in answer), ">", sep="")