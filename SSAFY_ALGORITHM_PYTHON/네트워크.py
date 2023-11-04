def solution(n, computers):
    visit=[False for _ in range(n)]
    answer=0
    
    for i in range(n):
        if not visit[i]:
            dfs(n, computers, i, visit)
            answer+=1

    return answer

def dfs(n, computers, x, visit):
    visit[x]=True
    for i in range(n):
        if not visit[i] and computers[x][i]==1:
            dfs(n,computers,i,visit)
