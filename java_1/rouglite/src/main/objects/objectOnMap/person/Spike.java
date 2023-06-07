package main.objects.objectOnMap.person;

import main.engine.Engine;
import main.objects.ListObjectOnMap;
import main.objects.objectOnMap.Object;

import java.util.HashSet;
import java.util.Random;

public class Spike extends Object {
    private int numberOfSpike = 15;
    public Spike (ListObjectOnMap listObjectOnMap) {
        this.charOnMap = 's';
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
        this.locationList = new HashSet<int[]>();
        this.listObjectOnMap = listObjectOnMap;
    }
    public void addOnMap() {
        Random random = new Random();
        for (int i=0; i<numberOfSpike; i++) {
            int[] newLocation;
            do {
                newLocation = new int[] {random.nextInt(numberOfRowsMap), random.nextInt(numberOfColumnsMap)};
            } while (listObjectOnMap.hasObjectAtLocation(newLocation) != '.');
            locationList.add(newLocation);
            listObjectOnMap.addObjectToList(charOnMap, locationList);
        }
    }

}
