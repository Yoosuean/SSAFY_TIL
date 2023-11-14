from collections import deque

# 상하좌우  / 좌상 좌하 우상 우하
dx=[-1,1,0,0,-1,1,-1,1]
dy=[0,0,-1,1,-1,-1,1,1]

def check(x,y,k,n):
    x-=1
    y-=1
    temp=[]
    for i in range(8):
        nx=x+dx[i]
        ny=y+dy[i]
        while True:
            if nx<0 or nx>=n or ny<0 or ny>=n:
                temp=[]
                break
            if maps[nx][ny]==0:
                temp=[]
                break
            if maps[nx][ny]==k:
                break
            else:
                temp.append([nx,ny])
            nx+=dx[i]
            ny+=dy[i]
        
        if k==1: rock=1
        else: rock=2
        
        for t in temp:
            maps[t[0]][t[1]]=rock
    maps[x][y]=k
                            
T=int(input())
for tc in range(T):
    N,M=map(int,input().split()) # N: 맵크기
    maps=[list(0 for _ in range(N)) for _ in range(N)]
    # 가운데 흑돌, 백돌 설정
    maps[N//2-1][N//2-1]=2
    maps[N//2][N//2]=2
    maps[N//2][N//2-1]=1
    maps[N//2-1][N//2]=1
    
    for i in range(M):
        R,C,K=map(int,input().split()) # r,c, 1: 흑돌 2: 백돌
        check(R,C,K,N)
        
    white_rock=0
    black_rock=0
    for i in range(N):
        for j in range(N):
            if maps[i][j]==1:
                black_rock+=1
            elif maps[i][j]==2:
                white_rock+=1
            
    print(f"#{tc+1} {black_rock} {white_rock}")
    
