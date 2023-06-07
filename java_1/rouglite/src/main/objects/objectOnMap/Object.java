package main.objects.objectOnMap;


import java.util.HashMap;
import java.util.HashSet;

public abstract class Object  {
    public char charOnMap;
    public HashSet<int[]> location;

    public HashSet<int[]> getLocation() {
        return location;
    }


}
