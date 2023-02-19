import sys

def yes_or_no(string):
    while "()" in string:
        string = string.replace("()", "")
    if string == "":
        print("YES")
    else:
        print("NO")
        
if __name__ == "__main__":
    N = int(sys.stdin.readline())

    array = []

    for i in range(N):
        order = sys.stdin.readline().strip()
        array.append(order)

    for i in array:
        yes_or_no(i)