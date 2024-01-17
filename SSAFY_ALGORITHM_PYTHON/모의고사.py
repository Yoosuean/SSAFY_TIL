def solution(answers):
    a=[1,2,3,4,5]
    b=[2,1,2,3,2,4,2,5]
    c=[3,3,1,1,2,2,4,4,5,5]
    cnt=[0,0,0]
    for i in range(len(answers)):
        if a[i-(i//len(a))*len(a)]==answers[i]:
            cnt[0]+=1
        if b[i-(i//len(b))*len(b)]==answers[i]:
            cnt[1]+=1
        if c[i-(i//len(c))*len(c)]==answers[i]:
            cnt[2]+=1
    max_val=max(cnt)
    res=[]
    for i in range(len(cnt)):
        if cnt[i]==max_val:
            res.append(i+1)
    return res
