from collections import deque

def solution(people, limit):
    people.sort()
    q=deque(people)
    cnt=0
    
    while q:
        if len(q)==1:
            cnt+=1
            break
        if q[0]+q[-1]<=limit:
            q.popleft()
            q.pop()
            cnt+=1
        else:
            q.pop()
            cnt+=1
            
    return cnt
