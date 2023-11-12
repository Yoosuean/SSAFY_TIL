from collections import deque

def solution(bridge_length, weight, truck_weights):
    time=0
    bridgeW=deque()
    bridgeL=deque()
    
    while True:
        if truck_weights and sum(bridgeW)+truck_weights[0]<=weight and len(bridgeL)<=bridge_length:
            bridgeW.append(truck_weights.pop(0))
            bridgeL.append(bridge_length)
            
        if len(bridgeW)==0:
            time+=1
            break   
        
        for i in range(len(bridgeW)):
            if bridgeL[i]>0:
                bridgeL[i]-=1
                
        if bridgeL[0]==0:
            bridgeW.popleft()
            bridgeL.popleft() 
        time+=1 

    return time
