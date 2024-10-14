from random import randint

list = ["Rock", "Paper", "Scissors"]

def winMessage(user, opponent):
    def printWinMessage(won, user, opponent):
        if(won):
            beat = "beats"
            win = "won"
        else:
            beat = "is beaten by"
            win = "lost"
        print(f"The opponent has chosen a {list[opponent]} as their weapon. {list[user]} {beat} {list[opponent]}. You {win}!")

    won = False

    if(user == opponent):
        print(f"You have both chosen the {list[user]} as your choice. It's a tie!")

    else:
        if(user==0 and opponent==2):
            won=True
        elif(user==1 and opponent == 0):
            won=True
        elif(user==2 and opponent==1):
            won=True
    printWinMessage(won, user, opponent)

computerChoice = randint(0,2)

for i in range(len(list)):
    print(f"{i}. {list[i]}")
userChoice = input("Choose what you want to use!")
#userChoice = randint(0,2)

print(f"You chose the {list[userChoice]}")
winMessage(userChoice, computerChoice)
