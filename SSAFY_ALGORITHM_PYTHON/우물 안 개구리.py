import sys

n,m=map(int,input().split())
num=list(map(int,input().split()))
friend=[[] for _ in range(n+1)]
cnt=0

for i in range(m):
  a,b=map(int,input().split())
  friend[a].append(num[b-1])
  friend[b].append(num[a-1])

for i in range(1,n+1):
  if len(friend[i])==0:
    cnt+=1
    continue
  if num[i-1]>max(friend[i]):
    cnt+=1

print(cnt)
