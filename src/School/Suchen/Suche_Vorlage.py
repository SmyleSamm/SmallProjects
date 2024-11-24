import csv

adressen = []
nachnamen = []

with open('adressdaten.csv') as daten:
    csv_reader_object =csv.reader(daten, delimiter=',')
    for row in csv_reader_object:
        adressen.append(row)
    for i in adressen:
        nachnamen.append(i[0])

def sucheNachname(name: str) -> int:
    if(name not in nachnamen):
        return -1
    zaehler = 1
    for i in nachnamen:
        if(i == name):
            return zaehler
        zaehler += 1

print(sucheNachname("Krause"))
























def anzahlAnNachnamen() -> list:
    l = []
    for i in nachnamen:
        x = [i]
        isIn = False
        for b in l:
            if(b[0] == i):
                b[1] += 1
                isIn = True
        if(not isIn):
            x.append(1)
            l.append(x)
    return l

def sortTwoDimListBySecondIndex(l: list[list[str, int]]) -> list[list[str, int]]:
    #check first if bigger, if not -> insert left. if yes -> go to the next and repeat
    return sorted(l, key=lambda x: x[1]) #wie das ergebniss aussehen sollte (von ChatGPT)

#print(sortTwoDimListBySecondIndex())
#print(anzahlAnNachnamen())


