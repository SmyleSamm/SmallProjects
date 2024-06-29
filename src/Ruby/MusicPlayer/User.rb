class User
    @is_logged_in = false
    attr_accessor :user_id, :user_name, :user_addresse
    def initialize(id, name, addresse)
        @user_id = id 
        @user_name = name
        @user_addresse = addresse
    end
    
    def login(name, addresse)
        if name == @user_name && addresse == @user_addresse
            puts "Logged-in successfully!"
        else
            puts "Failed while logging in"
        end 
    end
end