
# 상하좌우
dx=[-1,1,0,0]
dy=[0,0,-1,1]

def dfs(cnt,x,y,maps,visit):
    global res

    if cnt==m:
        res+=1
        return

    visit[x][y]=True
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<0 or nx>=n or ny<0 or ny>=n: continue
        if visit[nx][ny] or maps[nx][ny]==1: continue
        if m_list[cnt][0]==nx and m_list[cnt][1]==ny:
            dfs(cnt+1,nx,ny,maps,visit)
            visit[nx][ny]=False
        else:
            dfs(cnt,nx,ny,maps,visit)
            visit[nx][ny]=False


n,m=map(int,input().split()) # 격자의 크기, 방문 칸 수
m_list=[]
res=0
maps=[list(map(int,input().split())) for _ in range(n)]
visit=[list(False for _ in range(n)) for _ in range(n)]

for _ in range(m):
    a,b=map(int,input().split())
    m_list.append([a-1,b-1])

dfs(1,m_list[0][0],m_list[0][1],maps,visit)

print(res)
    
