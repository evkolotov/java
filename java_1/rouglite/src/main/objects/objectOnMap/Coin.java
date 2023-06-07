package main.objects.objectOnMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Coin extends Object{
    private int numberOfCoin = 10;
    private int numberOfRowsMap;
    private int numberOfColumnsMap;
    Random random = new Random();


    public Coin (int numberOfRowsMap, int numberOfColumnsMap) {
        this.charOnMap = '$';
        this.numberOfCoin = numberOfCoin;
        this.numberOfRowsMap = numberOfRowsMap;
        this.numberOfColumnsMap = numberOfColumnsMap;
        this.location = new HashSet<int[]>();
    }
    public void addCoinOnMap (ListObjectOnMap listObjectOnMap) {
        for (int i=0; i<numberOfCoin; i++) {
            int[] newLocation;
            do {
                newLocation = new int[] {random.nextInt(numberOfRowsMap), random.nextInt(numberOfColumnsMap)};
            } while (listObjectOnMap.hasObjectAtLocation(newLocation) != '.');
            location.add(newLocation);
        }
    }

}
