package src.SmyleGameEngine.SmyleTextAdventureLibary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class WorldObject
{
    private String name, description;
    private WorldObject[] connections;
    private String[] directions;
    private Object[][] directionsAndConnections; //Change everything to fit this implementation style

    public WorldObject(String name, String description){
        this.name = name;
        this.description = description;
        this.connections = new WorldObject[0];
        this.directions = new String[0];
    }
    public WorldObject[] getConnections(){
        LinkedList<WorldObject> tempWorld = new LinkedList<WorldObject>();

        Arrays.stream(this.connections)
            .filter(worldObject -> worldObject != null)
            .forEach(tempWorld::add);

        WorldObject[] worldObjects = new WorldObject[tempWorld.size()];

        IntStream.range(0, tempWorld.size())
            .forEach(i -> worldObjects[i] = tempWorld.get(i));
        return this.connections;
    }

    public String[] getDirections(){
        return directions;
    }
    public void setConnections(){

    }
    public void setDirections(){
        WorldObject[] worldObjects = new WorldObject[directions.length+1];
        Array.stream(this.connnections)
    }

    //ATTRIBUTES ACCECIBILITY

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
}