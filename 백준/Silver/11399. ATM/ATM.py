def solution(P):
    P.sort()
    total = 0
    time = 0
    for i in P:
        total += i + time
        time += i
    return total

if __name__ == "__main__":
    N = int(input())
    P = list(map(int, input().split()))
    print(solution(P))
