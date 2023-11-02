import heapq

def solution(scoville, K):
    mix_scoville=0
    cnt=0
    heapq.heapify(scoville)
    
    if scoville[0]>=K:
        return cnt
    
    while scoville[0]<K:
        if len(scoville)==1:
            cnt=-1
            break
        a=heapq.heappop(scoville)
        b=heapq.heappop(scoville)
        mix_scoville=a+(b*2)
        heapq.heappush(scoville,mix_scoville)
        cnt+=1 

    return cnt
