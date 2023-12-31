from itertools import product
from collections import deque
import copy

# 1) 구슬을 0~W 중 N개 뽑는 중복조합 구함
# 2) 구슬을 쏜 후에는 벽돌에 쓰여진 수만큼 bfs
# 3) 벽돌을 내린후 N까지 위의 과정 반복


# 상하좌우
dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(x,y,W,H,maps):
    q=deque()
    q.append((x,y,maps[x][y]))
    maps[x][y]=0

    while q:
        cx,cy,power=q.popleft()
        for i in range(4):
            nx=cx
            ny=cy
            for _ in range(power-1):
                nx+=dx[i]
                ny+=dy[i]
                if nx<0 or ny<0 or nx>=H or ny>=W: break
                if maps[nx][ny]==0: continue
                q.append((nx,ny,maps[nx][ny]))
                maps[nx][ny]=0



def blockDown(W,H,maps):
    stack=[[] for _ in range(W)]
    for i in range(W):
        for j in range(H):
            if maps[j][i]>0:
                stack[i].append(maps[j][i])
                maps[j][i]=0

    for i in range(W):
        for j in range(H-1,-1,-1):
            if stack[i]:
                maps[j][i]=stack[i].pop()
            else: break


def blockCount():
    cnt=0
    for i in range(H):
        for j in range(W):
            if maps[i][j]>0:
                cnt+=1
    return cnt



T=int(input())

for tc in range(1,T+1):
    N,W,H=map(int,input().split()) # 구슬쏘는 수, 가로, 세로
    maps=[list(map(int,input().split())) for _ in range(H)]
    copyMap=copy.deepcopy(maps)

    comb_shot=list(product(range(W),repeat=N))

    res=int(1e9)

    for comb in comb_shot:
        maps=copy.deepcopy(copyMap)
        for c in comb:
            for j in range(H):
                if maps[j][c]>0:
                    bfs(j,c,W,H,maps)
                    blockDown(W,H,maps) # 블록 내리기
                    break
                
        res=min(res,blockCount()) # 블록 개수 세기
        if res==0: # 시간초과 방지 
            break
    print(f'#{tc} {res}')
             

