import math

def solution(fees, records):
    cars=dict() 
    res=[]
    records.sort(key=lambda x : int(x[6:10]))

    for r in records: # 차량번호별 기록 정리
        num=r[6:10]
        if num not in cars:
            cars[num]=[]
        time=r[0:5]
        kind=r[11:]
        cars[num].append((time,kind))
        
    calc_record(fees,records,cars,res)
    return res
        
    
def calc_record(fees,records,cars,res):
    for key in cars.keys():
        time=0
        flag=False # False: 출차X  True: 출차O
        car_info=cars[key]
        for info in car_info:
            if info[1]=="IN": 
                in_time=info[0]
                flag=False
            else:
                out_time=info[0]
                time+=calc_time(in_time,out_time,0)
                flag=True
        if not flag: # 출차하지 않았으면
            time+=calc_time(in_time,"23:59",0)
        res.append(calc_fee(time,fees))
            
def calc_time(in_time,out_time,time):
    in_h=int(in_time[0:2])
    in_m=int(in_time[3:5])
    out_h=int(out_time[0:2])
    out_m=int(out_time[3:5])
    time+=(out_h-in_h)*60
    if in_m>out_m:
        time-=in_m-out_m
    else:
        time+=out_m-in_m
    return time

def calc_fee(time,fees):
    fee=0
    if time<=fees[0]:
        return fees[1]
    else:
        fee+=fees[1]
        time-=fees[0]
        fee+=math.ceil(time/fees[2])*fees[3]
        return fee
