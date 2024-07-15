from random import randint
print("Ghost Game")
alive = True
score = 0
while alive:
    ghostDoor = randint(1,3)
    print("In front of you are three doors.")
    print("Behind one is a ghost.")
    print("Which door do you want to open?")
    door = int(input("1, 2 or 3?"))
    if door == ghostDoor:
        print("Ghost!")
        alive = False
    else:
        print("No ghost!")
        print("You are one room further.")
        score += 1
print("Run away!")
print("Game Over! Score: ", score)
