n,k=map(int,input().split())
num= list(input())
res=[]
cnt=k
# 숫자의 순서 지켜야함
# 앞에 나온 숫자가 뒤에 나온 숫자보다 작을경우 없애기
for i in range(n):
    while res and cnt>0:
        if res[-1]<num[i]:
            res.pop()
            cnt-=1
        else:
            break
    res.append(num[i])

print(''.join(res[:n-k]))
