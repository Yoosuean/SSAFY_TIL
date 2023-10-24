from collections import deque

def solution(s):
    answer=check(s)

    return answer

def check(s):
    dq=deque(s)
    cnt=0
    for i in range(len(s)):
        temp=[]
        ch=True
        for j in dq:
            if j=="[" or j=="(" or j=="{":
                temp.append(j)
            else:
                if len(temp)==0:
                    ch=False
                    break
                x=temp.pop()
                if j==')':
                    if x!='(':
                        ch=False
                        break
                elif j=='}':
                    if x!='{':
                        ch=False
                        break
                else:
                    if x!='[':
                        ch=False
                        break
        if ch and len(temp)==0:
            cnt+=1
        # 문자열 돌리기
        dq.append(dq.popleft())
    return cnt
            
                            
                    
                
    
