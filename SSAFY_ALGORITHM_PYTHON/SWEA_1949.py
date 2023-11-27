from collections import deque

# BFS 
# 모든 등산로 구해보기
# NxN번 높이를 깎고, NxN번 bfs 돌리기

#상하좌우
dx=[-1,1,0,0]
dy=[0,0,-1,1]


def bfs(x,y,maps,N):
    visit=[list(False for _ in range(N)) for _ in range(N)]
    
    q=deque()
    q.append((x,y,1)) # x, y, dis

    maxDis=0

    while q:
        cx,cy,dis=q.pop()

        maxDis=max(maxDis,dis)

        for i in range(4):
            nx=cx+dx[i]
            ny=cy+dy[i]

            if nx<0 or ny<0 or nx>=N or ny>=N:
                continue

            if maps[cx][cy]>maps[nx][ny]:
                q.append((nx,ny,dis+1))
    return maxDis



T=int(input())
for tc in range(1,T+1):
    max_val=0
    max_res=0
    N,K=map(int,input().split())
    maps=[list(map(int,input().split())) for _ in range(N)]


    # 가장 높은 지형 찾기
    for i in range(N):
        max_val=max(max(maps[i]),max_val)

    max_list=[]
    for i in range(N):
        for j in range(N):
            if maps[i][j]==max_val:
                max_list.append([i,j])

    for i in range(N):
        for j in range(N):
            for k in range(K+1):
                maps[i][j]-=k
                for c in max_list:
                    max_res=max(bfs(c[0],c[1],maps,N),max_res)
                maps[i][j]+=k

    print(f'#{tc} {max_res}')
                
            
            
