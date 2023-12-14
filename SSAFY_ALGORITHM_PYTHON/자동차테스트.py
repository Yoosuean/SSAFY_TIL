
def binary_search(target,cars):
    start=0
    end=len(cars)-1

    while start<=end:
        mid=(start+end)//2

        if cars[mid]==target:
            return mid
        elif cars[mid]>target:
            end=mid-1
        else:
            start=mid+1
    return 0
    


n,q=map(int,input().split())
cars=list(map(int,input().split())) # 연비


cars.sort()

for _ in range(q):
    target=int(input())
    m=binary_search(target,cars)
    if m>0:
        print(m*(len(cars)-m-1))
    else:
        print(0)
