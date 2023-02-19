import sys
from collections import deque
N = int(sys.stdin.readline())

array = []

for i in range(N):
    order = sys.stdin.readline().strip()
    array.append(order)
    
deq = deque()

for i in array:
    if i == "pop":
        if len(deq) > 0:
            num = deq.popleft()
            print(num)
        else:
            print(-1)
    elif i == "size":
        print(len(deq))
    elif i == "empty":
        if len(deq) > 0:
            print(0)
        else:
            print(1)
    elif i == "front":
        if len(deq) > 0:
            print(deq[0])
        else:
            print(-1)
    elif i == "back":
        if len(deq) > 0:
            print(deq[-1])
        else:
            print(-1)
    else:
        deq.append(i[5:])