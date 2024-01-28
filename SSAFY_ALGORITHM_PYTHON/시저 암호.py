def solution(s, n):
    alphabet=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    answer = ''
    for i in s:
        if i==' ': 
            answer+=' '
            continue
        if i.isupper():
            temp=alphabet.index(i.lower())
            if temp+n<26:
                answer+=alphabet[temp+n].upper()
            else:
                answer+=alphabet[temp+n-26].upper()
        else:
            temp=alphabet.index(i)
            if temp+n<26:
                answer+=alphabet[temp+n]
            else:
                answer+=alphabet[temp+n-26]   

    return answer
