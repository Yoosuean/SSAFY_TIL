from collections import deque
def solution(maps):
    dx=[1,-1,0,0]
    dy=[0,0,-1,1]
    n=len(maps)
    m=len(maps[0])
    visited=[list(False for i in range(m)) for j in range(n)]
    
    q=deque()
    
    q.append((0,0,1))
    visited[0][0]=True
    
    while q:
        cur=q.popleft()
        
        if cur[0]==n-1 and cur[1]==m-1:
            return cur[2]
        
        for i in range(4):
            nx=cur[0]+dx[i]
            ny=cur[1]+dy[i]
            
            if nx<0 or nx>=n or ny<0 or ny>=m: continue
            if maps[nx][ny]==1 and not visited[nx][ny]:
                q.append((nx,ny,cur[2]+1))
                visited[nx][ny]=True
    return -1
