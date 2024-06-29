# This is a Spotify clone used only via the Terminal 
class MusicPlayer
    require_relative 'User'
    name = "Sammy"
    email = "test@email.de"
    user = User.new(9283764, name, email)
    user.login(name, email)
    
end