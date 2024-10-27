import discord
import discord.ext
from discord.ext import commands
import sys
import requests
#sys.path.append("D:\\") #For PC
sys.path.append("/home/Sammy/Coding") #For Linux
import config 

#importing secure bot_details
BOT_TOKEN = config.BOT_TOKEN1()
CHANNEL_ID = config.CHANNEL_ID()
GUILD_ID = config.GUILD_ID()

#setting-up bot
intents = discord.Intents.all() 
bot = commands.Bot(command_prefix="!",
                   intents=intents,
                   debug_guilds=[GUILD_ID],
                   help_command=None)

@bot.command()
async def hello(ctx):
    #mentions the user while saying hello to them
    await ctx.send(f"Hello {ctx.author.mention}!")



#DOES NOT WORK!!!!!!!!!
@bot.command()
async def stats(ctx, game: str = None): #if there is no game => print user statistics on current Server
    #https://public-api.tracker.gg/api/v1/{titleSlug}/standard/profile/{platformSlug}/{platformUserIdentifier}
    #https://public-api.tracker.gg/v2/division-2/standard/profile/{platform}/{platformUserIdentifier}
    #trn = f"https://public-api.tracker.gg/v2/apex/standard/profile/steam/Smyle_Samm"
    #headers = {"TRN-Api-Key": config.TRN_API_KEY()}
    #response = requests.get(trn, headers=headers)
    #await ctx.send(response.json())
    #print(response.status_code)
    #print(response.text)
    #if response.status_code == 200:
    #    return response.json()
    #else:
    #    return response.text
    await ctx.send("At this moment, Feature is not working!")

@bot.command()
async def messagesSend(ctx, member: discord.Member, limit: int = 1000):
    channel = ctx.channel
    count = 0

    async for message in channel.history(limit=limit):
        if message.author == member:
            count+=1

    await ctx.send(f"{member} send {count} messages in this channel!")



def getYoutubeData(accessData: str):
    youtube = f"https://www.googleapis.com/youtube/v3/channels?part=statistics&id={config.YOUTUBE_CHANNEL_ID()}&key={config.YOUTUBE_API_KEY()}"
    response = requests.get(youtube)
    data = response.json()
    
    if 'items' in data:
        subscribers = data['items'][0]['statistics'][accessData]
        return subscribers
    else:
        return "an error occurred or channel not found!"

def getTwitchData(accessData: str):
    #return "{this action is WIP}"
    twitch = f"https://api.twitch.tv/helix/users/follows?to_id={config.TWITCH_USER_ID("smyle_samm")}"
    headers = {
        "Client-ID": config.TWITCH_CLIENT_ID(),
        "Authorization": f"Bearer {config.GET_TWITCH_OAUTH_TOKEN()}"
    }
    response = requests.get(twitch, headers = headers)
    print(response)

    if response.status_code == 200:
        data = response.json()
        return data["total"]
    else:
        print(f"Error getting the follower count: {response.status_code}")
        return None
        
def getGithubData(accessData: str):
    github = f"https://api.github.com/users/SmyleSamm/{accessData}"
    response = requests.get(github)
    data = response.json()

    return len(data)

@bot.command()
async def social(ctx, platform: str = None, action: str = None):

    if platform is not None:
        platform = platform.lower()
    if action is not None:
        action = action.lower()

    social={
        "github": "https://github.com/SmyleSamm",
        "steam": "https://steamcommunity.com/id/SmyleSamm/",
        "twitch": "https://www.twitch.tv/smyle_samm",
        "youtube": "https://www.youtube.com/@smyle_samm1372"
    }

    actions={
        "github": {"followers": getGithubData("followers"),
                   "following": getGithubData("following")},
        "steam": {},
        "twitch": {"followers": getTwitchData("")},
        "youtube": {"followers": getYoutubeData("subscriberCount"),
                    "views": getYoutubeData("viewCount"),
                    "videos": getYoutubeData("videoCount")}
    }

    if platform is None:
        for name, link in social.items():
            await ctx.send(f"[{name.capitalize()}]({link})")
    else:
        if platform not in social:
            await ctx.send("I am sorry, but I dont linked my {platform}.\n"
                       "You can see all my socials with !social")    
        else:
            if action is None:
                await ctx.send(f"Here is the link to my [{platform}]({social[platform]})")

            elif action not in actions[platform]:
                if(actions[platform] is not None):
                    await ctx.send(f"There is no action called: {action}.\n"
                                   f"Supported actions for {platform} are: {", ".join(actions[platform].keys())}")
                else:
                    await ctx.send(f"{platform} does not support any actions.")
            else:
                if action in actions[platform]:
                    await ctx.send(f"SmyleSamm has {actions[platform][action]} {action}")
                  
def help_embed():
    embed = discord.Embed(title="Help Menu", color=discord.Color.pink())
    embed.add_field(name="!hello", value="Say hello to the bot, and the bot will greet you back", inline=False)
    embed.add_field(name="!social", value="Get my socials", inline=False)
    embed.add_field(name="/help or !help", value="Show this help menu", inline=False)
    return embed

@bot.command()
async def help(ctx):
    await ctx.send(embed=help_embed())

@bot.tree.command(name="help")
async def help(interaction: discord.Interaction):
    await interaction.response.send_message(embed=help_embed(), ephemeral=True)

@bot.event
async def on_ready():
    print(f"{bot.user} is live!")
    try:
        synced = await bot.tree.sync()
        for x in synced:
            print(f"{x} synced")
    except Exception as e:
        print(e)

bot.run(BOT_TOKEN)