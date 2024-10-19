from tkinter import *
#setting-up Window
root = Tk()
root.title("My first Python Application")
root.geometry("600x600")
points = 0
cps = 1
#creating Text
lbl = Label(root, text = f"Points: {points}")
lbl.grid()

#creating Button + Function
def clicked():
    global points
    points += cps
    lbl.configure(text = f"Points: {points}")

btn = Button(root, text = "Click me!",
             fg = "green", command=clicked)
btn.grid(column=1, row=0)


root.mainloop()