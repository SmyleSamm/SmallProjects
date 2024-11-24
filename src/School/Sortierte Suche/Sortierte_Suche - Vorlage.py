import csv

adressen = []

with open ('adressdaten_sortiert_name.csv') as data:
    csv_reader_object = csv.reader(data, delimiter=',')
    for row in csv_reader_object:
        adressen.append(row)

#In den obenstehenden Zeilen Code werden die Adressdaten einer CSV-Datei in eine Liste geschrieben.
#Die Adressen stehen folgendermaßen im Datensatz [ ['Krause', 'Stefanie', 'Brandenburgische Str. 20', '74343', 'Sachsenheim'], ['Brandt', 'Mandy', 'Scharnweberstrasse 84', '68199', 'Mannheim Almenhof'], ... ]

def suchePerson(name: str) -> list:
    for i in range(len(adressen)):
        
        ersterBuchstabeName = name[0]
        ersterBuchstabeAdressen = adressen[i][0][0]
        
        if(ersterBuchstabeName > ersterBuchstabeAdressen):
            return []
        if(ersterBuchstabeName == ersterBuchstabeAdressen):
            if(name == adressen[i][0]):
                return adressen[i]

print("Name der gesuchten Person: ")
name = str(input())
personenDaten = suchePerson(name)
print(f"Die Daten von {name} lauten: ")
for i in personenDaten:
    print(i)
