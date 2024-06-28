@content = []
def listTodos
    todos = ["exit", "view", "edit", "load", "save"]
    for a in 0..4 do 
        puts "#{a}. #{todos[a]} ToDo-List"
    end 
end

def clear
    puts "\e[H\e[2J"
end

def view
    for x in 0..@content.length()-1
        puts "#{x+1} #{@content[x]}"
    end
end

def edit
    listEditOption
    option = gets.to_i
    case option 
    when 0 
        main
    when 1
        puts "Name the ToDo you want to add"
        taskName = gets.to_s
        @content.push(taskName)
    when 2
        puts "Enter the Index of the ToDo you want to rename"
        view 
        renameAtIndex = gets.to_i 
        puts "Enter the name of the new ToDo"
        newTaskName = gets.to_s 
        @content[renameAtIndex-1] = newTaskName
    when 3
        puts "Enter the Index of the ToDo you want to delete"
        view
        deleteToDoAtIndex = gets.to_i
        @content.delete_at(deleteToDoAtIndex-1)
    else
        puts "failed at edit"
        edit
    end
    edit 
end

def load
    puts "Load"
end

def save
    puts "Save"
end

def choseTodo(todo)
    case todo
    when 1
        clear
        view
    when 2 
        clear
        edit
    when 3
        clear
        load
    when 4 
        clear
        save
    when 0
        clear
        puts "See you again!"
        exit
    else
        puts "Failed choosing Todo"
    end
    main
end
puts "Welcome to the ToDo-List!"
def main
    puts "Chose what to do:"
    #list options
    options = ["exit", "add", "rename", "delete"]
    for a in 0..3 do 
        puts "#{a}. #{options[a]}"
    end

    choseTodo(gets.to_i)
end
main