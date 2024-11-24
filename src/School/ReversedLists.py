def rev1(L: list) -> list:
    #umdrehen einer Liste
    #Versuch 1, mit zwei Listen
    K = []
    for i in range(len(L)-1, -1, -1):
        K.append(L[i])
    return K

def rev2(L: list) -> list:
    #umdrehen einer Liste
    #Versuch 2, mit nur einer Liste
    iterrations = int(len(L)/2)
    for i in range(0, iterrations):
        temp1 = L[i]
        L[i] = L[len(L)-1-i]
        L[len(L)-1-i] = temp1  
    return L

L = [1,2,3,4,5,1,2,3]
print(f"normal list: {L}")
print(f"reversed with 1: {rev1(L)}")
print(f"reversed with 2: {rev2(L)}")
