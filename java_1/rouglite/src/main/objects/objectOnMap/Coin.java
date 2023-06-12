package main.objects.objectOnMap;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

public class Coin extends ObjectOnMap {
    private int numberOfCoinOnMap = 30;

    public Coin (ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //InitWallUseForCreateAllCoinsOnMap
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
    }
    public Coin (int[] currentLocation, ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = '$';
        this.currentLocation = currentLocation;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
    }
    public void addCurrentCoinOnMap () {
        listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
    }
    public void addCoinOnCurrentLocation (int [] location) {
        Coin currentCoin = new Coin(location, listLocationAndObjectOnMap);
        currentCoin.addCurrentCoinOnMap();
    }
    public void addOnMap() {
        //add random Coin
        int[] currentLocation;
        int counter = 0;
        while (counter != numberOfCoinOnMap) {
            int currentY = Engine.getEngine().random.nextInt(numberOfRowsMap);
            int currentX = Engine.getEngine().random.nextInt(numberOfColumnsMap);
            currentLocation = new int[] {currentY,currentX};
            if (listLocationAndObjectOnMap.hasObjectAtLocation(currentLocation) == null) {
                Coin currentCoin = new Coin(currentLocation, listLocationAndObjectOnMap);
                currentCoin.addCurrentCoinOnMap();
                counter++;
            }
        }
    }
}
