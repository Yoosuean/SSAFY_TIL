prime_set = set()

def isPrime(number):
    if number in (0, 1):
        return False
    lim = int(number ** 0.5 + 1)
    for i in range(2, lim):
        if number % i == 0:
            return False

    return True


def makeCombinations(combination, others):
    if combination != "":
        if isPrime(int(combination)):
            prime_set.add(int(combination))
    
    for i in range(len(others)):
        makeCombinations(combination + others[i], others[:i] + others[i + 1:])


def solution(numbers):
    makeCombinations("", numbers)

    answer = len(prime_set)
    return answer
