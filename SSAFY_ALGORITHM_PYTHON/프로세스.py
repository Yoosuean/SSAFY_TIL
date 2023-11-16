from collections import deque

def solution(priorities, location): 
    q=deque(priorities)
    priorities.sort()
    cnt=0
    idx=location
    
    while q:
        temp=q.popleft()
        idx-=1
        if temp==priorities[-1]:
            cnt+=1
            if idx==-1:
                return cnt
            priorities.pop()
        else:
            q.append(temp)
            if idx<0:
                idx+=len(q)
    
    return cnt
