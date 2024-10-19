import discord
import discord.ext
from discord.ext import commands
import sys
sys.path.append("D:\\")
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

@bot.command()
async def social(ctx):
    #Links of my socials
    github = "[GitHub](https://github.com/SmyleSamm)"
    steam = "[Steam](https://steamcommunity.com/id/SmyleSamm/)"
    ttv = "[Twitch](https://www.twitch.tv/smyle_samm)"

    #sending links to the user
    await ctx.send(github)
    await ctx.send(steam)
    await ctx.send(ttv)

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