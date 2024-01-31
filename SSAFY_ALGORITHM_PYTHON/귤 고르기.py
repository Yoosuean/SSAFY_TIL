def solution(k, tangerine):
    tan_dict=dict()
    for t in tangerine:
        if t not in tan_dict:
            tan_dict[t]=1
        else:
            tan_dict[t]+=1
    answer = 0
    
    arr=list(sorted(tan_dict.values(),reverse=True))
    
    for i in range(len(arr)):
        k-=arr[i]
        answer+=1
        if k<=0: break
            
    return answer
