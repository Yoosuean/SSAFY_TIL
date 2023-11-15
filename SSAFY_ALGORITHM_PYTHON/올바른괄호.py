def solution(s):
    temp_arr=[]
    
    for i in s:
        if i=='(':
            temp_arr.append('(')
        else:
            if(len(temp_arr)>0):
                temp_arr.pop()
            else:
                return False
    if len(temp_arr)==0: return True
    return False 
