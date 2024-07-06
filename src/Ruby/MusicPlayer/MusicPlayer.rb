# This is a Spotify clone used only via the Terminal 
class MusicPlayer
    require_relative 'User'
    def createNewUser(name, email)
        if(User.login(name, email))
            puts "account already excists"
        else
            user = User.new(2934874, name, email)
            return user
        end
    end 
end
class ServerOrSmth
    def initialize
        @user_List = []
        puts "initialize"
        testing
    end
    
    def testing
        puts "testing"
        require_relative 'MusicPlayer'
        require_relative 'User'
        musicPlayer = MusicPlayer.new
        name = "Sammy"
        email = "test@email.de"
        user = musicPlayer.createNewUser(name, email)
        puts "yems"
        User.login(name, email)
        @user_List.push(user)
    end
    
end 

server = ServerOrSmth.new 