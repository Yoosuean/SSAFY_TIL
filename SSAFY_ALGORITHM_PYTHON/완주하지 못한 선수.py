from collections import defaultdict

def solution(participant, completion):
    part_dic=defaultdict(int)
    answer=''
    for p in participant:
        part_dic[p]+=1
    
    for key in completion:
        part_dic[key]-=1

    for item,key in part_dic.items():
        if key>0:
            answer+=item
    return answer
