def backtracking(idx,num, plus, minus, mul, div):
    global min_value, max_value
    if idx == N:
        min_value = min(min_value,num)
        max_value = max(max_value, num)
        return
    if plus > 0:
        backtracking(idx+1, num+nums[idx], plus-1, minus, mul, div)
    if minus > 0:
        backtracking(idx+1, num-nums[idx], plus,minus-1, mul, div)
    if mul > 0:
        backtracking(idx+1, num*nums[idx], plus,minus, mul-1, div)
    if div > 0:
        if num >= 0:
            backtracking(idx+1, num//nums[idx], plus,minus, mul, div-1)
        else:
            backtracking(idx+1, -(-num//nums[idx]),plus,minus,mul, div-1)

N = int(input())
nums = list(map(int,input().split()))
plus, minus, mul, div = map(int, input().split())
max_value = -1e9
min_value = 1e9
backtracking(1,nums[0], plus, minus,mul, div)
print(max_value)
print(min_value)
