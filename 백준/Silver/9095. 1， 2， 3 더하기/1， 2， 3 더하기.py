def solution(n):
    if n > 3:
        return solution(n-1) + solution(n-2) + solution(n-3)
    elif n == 3:
        return 4
    elif n == 2:
        return 2
    else:
        return 1

T = int(input())

for i in range(T):
    n = int(input())
    print(solution(n))