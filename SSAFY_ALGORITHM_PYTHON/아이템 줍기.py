from collections import deque

# 상 하 좌 우
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer=0
    maps=[[-1]*102 for _ in range(102)]
    for r in rectangle:
        x1,y1,x2,y2=r[0],r[1],r[2],r[3]
        x1*=2
        y1*=2
        x2*=2
        y2*=2
        for i in range(x1,x2+1):
            for j in range(y1,y2+1):
                if x1<i<x2 and y1<j<y2:
                    maps[i][j]=0
                if maps[i][j]!=0:
                    maps[i][j]=1
    
    visit=[list(False for _ in range(102)) for _ in range(102)]
    q=deque()
    q.append((characterX*2, characterY*2,0))
    visit[characterX*2][characterY*2]=True
    
    while q:
        x,y,dis=q.popleft()
        
        if x==itemX*2 and y==itemY*2:
            answer=dis//2
            break
        
        for i in range(4):
            nx=dx[i]+x
            ny=dy[i]+y         
            if nx<0 or nx>=102 or ny<0 or ny>=102: continue    
            if not visit[nx][ny] and maps[nx][ny]==1:
                q.append((nx,ny,dis+1))
                visit[nx][ny]=True    
    return answer
