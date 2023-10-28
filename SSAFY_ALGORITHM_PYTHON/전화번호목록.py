def solution(phone_book):
    lens = set([len(i) for i in phone_book])
    for i in lens:
        no = [x[:i] for x in phone_book if len(x) != i]
        yes = [x[:i] for x in phone_book if len(x) == i]
        if set(no) & set(yes):
            return False
    return True
