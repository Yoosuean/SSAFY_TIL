n,m=map(int,input().split())
r,c,d=map(int,input().split())
direction=[(1,0),(0,1),(-1,0),(0,-1)]
arr=[list(map(int,input().split())) for _ in range(n)]
res=0

def solution(x,y,d):
    global res
    if not arr[x][y]:
        arr[x][y]=2
        res+=1
    
    for _ in range(4):
        tmp=(3+d)%4
        nx=direction[tmp][0]+x
        ny=direction[tmp][1]+y
        if not arr[nx][ny]:
            solution(nx,ny,tmp)
            return
        d=tmp  

    tmp=(d+2)%4
    nx=x+direction[tmp][0]
    ny=y+direction[tmp][1]
    if arr[nx][ny]==1:
        print(res)
        return
    solution(nx,ny,d)
solution(r,c,d)
