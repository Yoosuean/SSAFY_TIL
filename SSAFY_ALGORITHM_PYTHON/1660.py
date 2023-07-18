#BOJ 1660 캡틴 이다솜
import sys
input = sys.stdin.readline

n = int(input())

ball=[]
num=0
tmp=1

while n > num:
    num+=(tmp*(tmp+1))//2
    ball.append(num)
    tmp+=1

dp = [300001 for _ in range(n+1)]
for i in range(1,n+1):
    for j in ball:
        if j==i:
            dp[i] = 1
            break
        if j>i:
            break
        dp[i]=min(dp[i], dp[i-j]+1)
print(dp[n])