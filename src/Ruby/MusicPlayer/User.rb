class User
    @is_logged_in = false
    attr_accessor :user_id, :user_name, :user_addresse
    def initialize(id, name, addresse)
        @user_id = id 
        @user_name = name
        @user_addresse = addresse
    end
    
    def self.login(name, addresse)
        if name == @user_name && addresse == @user_addresse
            puts "Logged-in successfully!"
            return true 
        else
            puts "Failed while logging in #{name} #{addresse}"
            return false 
        end 
    end
end