def solution(numbers):
    numbers=list(map(str,numbers))
    nums=sorted(numbers,key=lambda x : (x*4)[:4], reverse=True)    
    return str(int(''.join(nums)))
    
