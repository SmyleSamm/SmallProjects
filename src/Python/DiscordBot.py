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
                   debug_guilds=[GUILD_ID])

@bot.command()
async def hello(ctx):
    await ctx.send(f"Hello {ctx.author.mention}!")

@bot.tree.command(name="help")
async def help(interaction: discord.Interaction):
    await interaction.response.send_message(f"Hello {interaction.user.mention}!\n\n"
        "!hello: Say hello to the bot, he will say hello back to you!\n"
        "/help: Open the help menu, just like you did right now!", 
        ephemeral=True)

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