def solution(genres, plays):
    answer=[]
    genreDict=dict()
    lengenres=len(genres)
    
    for i in range(lengenres):
        genre=genres[i]
        play=plays[i]
        
        if genreDict.get(genre):
            genreDict[genre].append((play,i))
            genreDict[genre][0]+=play
        else:
            genreDict[genre]=[play,(play,i)]
    genreList=sorted(list(genreDict.values()), key=lambda x: x[0], reverse=True)
    
    for gen in genreList:
        genre_order=sorted(gen[1:], key=lambda x: (-x[0],x[1]))
        for i in range(min(2,len(gen)-1)):
            answer.append(genre_order[i][1])
    return answer
