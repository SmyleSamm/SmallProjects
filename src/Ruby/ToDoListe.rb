@content = []
def clear
    puts "\e[H\e[2J"
end

def view
    #if empty say that its empty!!
    for x in 0..@content.length()-1
        puts "#{x+1} #{@content[x]}"
    end
end

def edit
    #list options
    options = ["exit", "add", "rename", "delete"]
    for a in 0..3 do 
        puts "#{a}. #{options[a]}"
    end

    option = gets.to_i
    case option 
    when 0 #exit case
        main
    when 1 #add case
        puts "Name the ToDo you want to add"
        taskName = gets.chomp.strip
        @content.push(taskName) unless taskName.empty?
        clear 
    when 2 #rename case
        puts "Enter the Index of the ToDo you want to rename"
        view 
        renameAtIndex = gets.to_i 
        puts "Enter the name of the new ToDo"
        newTaskName = gets.to_s 
        @content[renameAtIndex-1] = newTaskName
        clear 
    when 3 #delete case 
        puts "Enter the Index of the ToDo you want to delete"
        view
        deleteToDoAtIndex = gets.to_i
        @content.delete_at(deleteToDoAtIndex-1)
        clear 
    else
        puts "failed at edit"
    end
    edit 
end

def load
    file_data = File.read("user/save/Todo-List/MyNewTodo1.txt").split
    for a in 0..file_data.length-1
        @content[a] = file_data[a]
    end
end

def save
    File.write("user/save/Todo-List/MyNewTodo1.txt", @content.join("\n"))

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
        clear
        puts "Failed choosing Todo"
    end
    main
end
def main
    puts "Chose what to do:"
    todos = ["exit", "view", "edit", "load", "save"]
    for a in 0..4 do 
        puts "#{a}. #{todos[a]} ToDo-List"
    end 
    choseTodo(gets.to_i)
end
clear 
puts "Welcome to the ToDo-List!"
main