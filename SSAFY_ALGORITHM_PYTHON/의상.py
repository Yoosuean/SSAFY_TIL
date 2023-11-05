def solution(clothes):
    k=dict() # 옷의 종류
    
    for clothe in clothes:
        if clothe[1] not in k:
            k[clothe[1]]=1
        else:
            k[clothe[1]]+=1
    a=0
    b=1
    
    sum=1
    
    for i in k:
        sum*=(k[i]+1)
    
    return sum-1
        
