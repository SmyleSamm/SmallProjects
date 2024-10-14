from random import randint

coChosen = randint(0,2)
list = ["Rock", "Paper", "Scissors"]
print("Choose what you want to use!")
for i in range(len(list)):
    print(f"{i}. {list[i]}")
chosen = randint(0,2)
print(f"You chose the {list[chosen]}")
if chosen == coChosen:
    print(f"You have both chosen the {list[chosen]} as your choice!")
elif chosen==0:
    if coChosen==2:
        print(f"The computer chose {list[coChosen]}. You won!")
    else:
        print(f"The Computer chose {list[coChosen]}. You lost!")
elif chosen==1:
    if coChosen==0:
        print(f"The computer chose {list[coChosen]}. You won!")
    elif coChosen==2:
        print(f"The Computer chose {list[coChosen]}. You lost!")
elif chosen==2:
    if coChosen==1:
        print(f"The computer chose {list[coChosen]}. You won!")
    elif coChosen==0:
        print(f"The Computer chose {list[coChosen]}. You lost!")