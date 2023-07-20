#BOJ 4435 중간계 전쟁
T=int(input())

for tc in range(T):
    a,b,c,d,e,f=map(int,input().split())
    aa,bb,cc,dd,ee,ff,gg=map(int,input().split())
    a_score=a+2*b+3*c+3*d+4*e+10*f
    b_score=aa+2*bb+2*cc+2*dd+3*ee+5*ff+10*gg

    if a_score>b_score:
        print("Battle "+str(tc+1)+": Good triumphs over Evil")
    elif a_score<b_score:
        print("Battle "+str(tc+1)+": Evil eradicates all trace of Good")
    else:
        print("Battle "+str(tc+1)+": No victor on this battle field")