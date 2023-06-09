package main.objects.objectOnMap;


import main.objects.ListLocationAndObjectOnMap;

import java.util.HashSet;

public abstract class ObjectOnMap {

    public char charOnMap;
    public int[] currentLocation;

    public ListLocationAndObjectOnMap listLocationAndObjectOnMap;
    public int numberOfRowsMap;
    public int numberOfColumnsMap;
    public int maxHp;
    public int currentHp;
    public int damage;
    public abstract void addOnMap ();
    public void dispose () {
        listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
    }

}
