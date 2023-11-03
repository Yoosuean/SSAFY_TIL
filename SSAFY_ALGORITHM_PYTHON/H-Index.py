from collections import Counter

def solution(citations):
    citations.sort()
    cita=dict(Counter(citations)) 
    curr=0
    
    for i in range(citations[-1],-1,-1):
        if i in cita:
            curr+=cita[i]
        if curr>=i:
            return i
