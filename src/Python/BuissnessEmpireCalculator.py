BuilderC = 2650
MetalC = 1171
WoodC = 324
ConcreteC = 47

PrivateHouse = {
    "Builder": 4,
    "Metal": 4,
    "Wood": 50,
    "Concrete": 170,
    "Cost": 59200,
    "Time": 3
}
OfficeBuilding = {
    "Builder": 13,
    "Metal": 12,
    "Wood": 400,
    "Concrete": 1500,
    "Cost": 385300,
    "Time": 10
}
TradeCenter = {
    "Builder": 90,
    "Metal": 25,
    "Wood": 300,
    "Concrete": 3800,
    "Cost": 644130,
    "Time": 12
}
ApartmentBuilding = {
    "Builder": 150,
    "Metal": 660,
    "Wood": 2200,
    "Concrete": 30200,
    "Cost": 4161225,
    "Time": 20
}
Skyscraper = {
    "Builder": 800,
    "Metal": 1450,
    "Wood": 2800,
    "Concrete": 190000,
    "Cost": 20482000,
    "Time": 35
}
Buildings = {
    "PrivateHouse": PrivateHouse,
    "OfficeBuilding": OfficeBuilding,
    "TradeCenter": TradeCenter,
    "ApartmentBuilding": ApartmentBuilding,
    "Skyscraper": Skyscraper
}

def getBuildingInfo(building_name: str, info: str):
    building = Buildings[building_name]
    request = building[info]
    
    return request

def calculateCost(building_name: str):
    building = Buildings[building_name]

    builderCost = building["Builder"] * BuilderC
    metalCost = building["Metal"] * MetalC
    woodCost = building["Wood"] * WoodC
    concreteCost = building["Concrete"] * ConcreteC

    totalcost = builderCost + metalCost + woodCost + concreteCost

    return totalcost 

def calculateProfit(building_name: str):
    building = Buildings[building_name]
    cost = calculateCost(building_name)

    margin = building["Cost"]
    profit = margin - cost

    return profit 

def bestOption(money: int):
    maxProfit = 0
    build = "PrivateHouse"
    iMax = 0
    for building in Buildings:
        cost = calculateCost(building)
        i = 0
        while(money >= cost*i):
            if(money >= cost*i):
                i = i + 1
        i = i - 1
        if(calculateProfit(building) * i > maxProfit and money >= cost and i != 0):
            build = building
            maxProfit = calculateProfit(building) * i
            iMax = i
    print(f"Profit: {maxProfit} Building: {build} Times: {iMax}")
    printBuildingStats(build, iMax)
        

def printBuildingStats(building_name: str, times: int):
    cost = calculateCost(building_name) * times
    profit = calculateProfit(building_name) * times
    duration = getBuildingInfo(building_name, "Time")
    stableIncome = profit / duration 
    builder = getBuildingInfo(building_name, "Builder") * times 
    metal = getBuildingInfo(building_name, "Metal") * times 
    wood = getBuildingInfo(building_name, "Wood") * times 
    concrete = getBuildingInfo(building_name, "Concrete") * times 

    print(f"Printing stats for {building_name} when building it {times} times!\n"
        f"The project will make a profit of {profit} after {duration}h\n"
        f"The stabel income for this project is: {stableIncome}/h\n"
        f"Material cost: {cost}\n"
        f"Builder: {builder},\n"
        f"Metal: {metal},\n"
        f"Wood: {wood},\n"
        f"Concrete: {concrete}\n")

bestOption(531308)
