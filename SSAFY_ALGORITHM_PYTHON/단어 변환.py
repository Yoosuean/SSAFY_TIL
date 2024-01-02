INF=int(1e9)
min_res=INF
def solution(begin, target, words):
    global min_res
    w_len=len(words)
    checked=[False for _ in range(w_len)]
    
    dfs(begin,target,words,0,w_len,checked)
    
    if min_res==INF:
        min_res=0
    return min_res

def dfs(begin,target,words,cnt,w_len,checked):
    global min_res
    if begin==target:
            print(cnt)
            min_res=min(cnt,min_res)
            return
        
    for word in range(len(words)):
        if checked[word]:
            continue
        same=0
        for i in range(len(words[word])):
            temp=words[word]
            if temp[i]==begin[i]:
                same+=1
        if same==2:
            checked[word]=True
            dfs(words[word],target,words,cnt+1,w_len,checked)
            checked[word]=False
        
    
