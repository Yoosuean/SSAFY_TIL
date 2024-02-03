def DFS(s,graph,visited,link):
    cnt=1
    visited[s]=True
    for v in graph[s]:
        if not visited[v] and link[s][v]:
            cnt+=DFS(v,graph,visited,link)
    return cnt


def solution(n, wires):
    answer=int(1e9)
    
    link=[[True]*(n+1) for _ in range(n+1)]
    graph=[[] for _ in range(n+1)]
    
    for a,b in wires:
        graph[a].append(b)
        graph[b].append(a)
        
    for a,b in wires:
        visited=[False]*(n+1)
        link[a][b]=False
        a_cnt=DFS(a, graph, visited, link)
        b_cnt=DFS(b, graph, visited, link)
        link[a][b]=True
        
        answer=min(answer,abs(a_cnt-b_cnt))
    return answer
