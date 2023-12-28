import heapq

N=int(input())
total=[0 for _ in range(N)]


for _ in range(3):
    score_q=[]
    heap_sort=[]
    dic={}
    idx=0
    score=list(map(int,input().split()))
    for i in score:
        heapq.heappush(score_q,-i)
    for i in range(len(score)):
        heap_sort.append(-heapq.heappop(score_q))  

    for s in heap_sort:
        idx+=1
        if s not in dic:
            dic[s]=idx
        
    ranks=[]
    for i in range(len(score)):
        ranks.append(dic[score[i]])

    for i in range(len(ranks)):
        if i==len(ranks)-1:
            print(ranks[i])
        else:
            print(ranks[i],end=' ')

    # total 구하기
    for i in range(len(score)):
        total[i]+=score[i]

total_q=[]
for i in total:
    heapq.heappush(total_q,-i)
total_sort=[]
for i in range(len(total)):
    total_sort.append(-heapq.heappop(total_q))

ranks=[]
dic={}
idx=0

for s in total_sort:
    idx+=1
    if s not in dic:
        dic[s]=idx

for i in range(len(total)):
    ranks.append(dic[total[i]])

for i in range(len(ranks)):
    if i==len(ranks)-1:
        print(ranks[i])
    else:
        print(ranks[i],end=' ')
