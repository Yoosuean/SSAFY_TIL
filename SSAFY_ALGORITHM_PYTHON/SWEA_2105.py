# 우하 / 좌하 / 우상 / 좌상
dx=[1,1,-1,-1]
dy=[1,-1,-1,1]
res=0

def dfs(x,y,n,sd,cnt,cafe,sx,sy):
    global res

    for i in range(sd,4):
        nx=x+dx[i]
        ny=y+dy[i]

        if nx<0 or nx>=n or ny<0 or ny>=n:
            continue

        if nx==sx and ny==sy and cnt>3:
            res=max(res,cnt)
            return

        if maps[nx][ny] in cafe:
            continue

        cafe.add(maps[nx][ny])
        dfs(nx,ny,n,i,cnt+1,cafe,sx,sy)
        cafe.remove(maps[nx][ny])   


T=int(input())

for tc in range(T):
    N=int(input())
    maps=[list(map(int,input().split())) for _ in range(N)]
    cafe=set()
    res=-1

    for i in range(N):
        for j in range(N):
            cafe.clear()
            cafe.add(maps[i][j])
            sx=i
            sy=j
            dfs(i,j,N,0,1,cafe,sx,sy)
    print(f"#{tc+1} {res}")
 
