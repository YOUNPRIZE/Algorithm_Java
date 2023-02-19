import sys

N = int(sys.stdin.readline())

array = []

for i in range(N):
    order = sys.stdin.readline().strip()
    array.append(order)
    
stack = []

for i in array:
    if i == "pop":
        if len(stack) > 0:
            num = stack.pop()
            print(num)
        else:
            print(-1)
    elif i == "size":
        print(len(stack))
    elif i == "empty":
        if len(stack) > 0:
            print(0)
        else:
            print(1)
    elif i == "top":
        if len(stack) > 0:
            print(stack[-1])
        else:
            print(-1)
    else:
        stack.append(i[5:])