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
        WorldObject[] objects = new WorldObject[directionsAndConnections.length];
        IntStream.range(0, this.directionsAndConnections.length)
            .forEach(i -> objects[i] = (WorldObject)this.directionsAndConnections[i][1]);
        return objects;
    }
    public String[] getDirections(){
        String[] directions = new String[directionsAndConnections.length];
        IntStream.range(0, this.directionsAndConnections.length)
            .forEach(i -> directions[i] = (String)this.directionsAndConnections[i][0]);
        return directions;
    }
    public void addNewConnections(Object[][] directionsAndConnections){
        Object[][] newConnection = new Object[this.directionsAndConnections.length+directionsAndConnections.length][];
        IntStream.range(0, this.directionsAndConnections.length)
            .forEach(i -> newConnection[i] = this.directionsAndConnections[i]);
        IntStream.range(this.directionsAndConnections.length, directionsAndConnections.length)
            .forEach(i -> newConnection[i] = directionsAndConnections[i-this.directions.length]);
        this.directionsAndConnections = newConnection;
    }

    //ATTRIBUTES ACCECIBILITY

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
}