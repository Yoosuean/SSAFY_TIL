answer=0

def solution(numbers, target):
    global answer
        
    dfs(0,0,numbers,target)
        
    return answer

def dfs(idx,sum,numbers,target):
    global answer
    if idx==len(numbers):
        if sum==target:
            answer+=1
        return
    else:
        dfs(idx+1,sum+numbers[idx],numbers,target)
        dfs(idx+1,sum-numbers[idx],numbers,target)
