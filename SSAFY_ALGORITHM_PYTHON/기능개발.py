from collections import deque

def solution(progresses, speeds):
    dp=deque(progresses)
    cnt=0
    res=[]
    while len(dp)>0:
        for i in range(len(dp)):
            dp[i]+=speeds[i]
        while dp and dp[0]>=100:
            dp.popleft()
            speeds.pop(0)
            cnt+=1
        if cnt == 0: continue
        res.append(cnt)
        cnt=0
    
    return res
