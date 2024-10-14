from tkinter import *
#setting-up Window
root = Tk()
root.title("My first Python Application")
root.geometry("600x600")

#creating Text
lbl = Label(root, text = "Hello")
lbl.grid()

#creating Button + Function
def clicked():
    lbl.configure(text = "I got clicked")

btn = Button(root, text = "Click me!",
             fg = "green", command=clicked)
btn.grid(column=1, row=0)


root.mainloop()