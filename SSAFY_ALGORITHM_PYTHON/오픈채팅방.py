def solution(record):
    user=dict()
    answer=[]
    
    for s in record:
        command=list(s.split())
        if command[0]=='Leave':
            continue
        user[command[1]]=command[2]
        
    
    for s in record:
        command=list(s.split())
        if command[0]=='Enter':
            answer.append(user[command[1]]+"님이 들어왔습니다.")
        if command[0]=='Leave':
            answer.append(user[command[1]]+"님이 나갔습니다.")
        
    return answer
