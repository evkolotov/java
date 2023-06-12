package main.objects.objectOnMap;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

import java.util.ArrayList;


public class Chest extends ObjectOnMap{
    private ListLocationAndObjectOnMap listLocationAndObjectOnMap;
    private GeneratorLoot generatorLoot;
    private Coin coin;
    private int numberOfChestOnMap = 10;
    public Chest (ListLocationAndObjectOnMap listLocationAndObjectOnMap, GeneratorLoot generatorLoot, Coin coin) {
        //InitWallUseForCreateAllCoinsOnMap
        this.currentLocation = currentLocation;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.generatorLoot = generatorLoot;
        this.coin = coin;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
    }
    private Chest (int[] currentLocation, ListLocationAndObjectOnMap listLocationAndObjectOnMap, GeneratorLoot generatorLoot, Coin coin) {
        //ObjectOnMap
        this.charOnMap = '&';
        this.currentLocation = currentLocation;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.generatorLoot = generatorLoot;
        this.coin = coin;
    }
    @Override
    public void addOnMap() {
        //add random Chest
        int[] currentLocation;
        int counter = 0;
        while (counter != numberOfChestOnMap) {
            int currentY = Engine.getEngine().random.nextInt(numberOfRowsMap);
            int currentX = Engine.getEngine().random.nextInt(numberOfColumnsMap);
            currentLocation = new int[] {currentY,currentX};
            if (listLocationAndObjectOnMap.hasObjectAtLocation(currentLocation) == null) {
                Chest currentChest = new Chest(currentLocation, listLocationAndObjectOnMap, generatorLoot, coin);
                currentChest.addCurrentChestOnMap();
                counter++;
            }
        }
    }
    private void addCurrentChestOnMap () {
        listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
    }
    public void dispose() {
        listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
        generatorLoot.generateLootOnLocation(currentLocation);
        ArrayList<int[]> listLocationAroundChosenChest = new ArrayList<>();
        listLocationAroundChosenChest.add(new int[] {currentLocation[0]+1, currentLocation[1]});
        listLocationAroundChosenChest.add(new int[] {currentLocation[0]-1, currentLocation[1]});
        listLocationAroundChosenChest.add(new int[] {currentLocation[0], currentLocation[1]+1});
        listLocationAroundChosenChest.add(new int[] {currentLocation[0], currentLocation[1]-1});
        for (int[] location : listLocationAroundChosenChest) {
            if (listLocationAndObjectOnMap.hasObjectAtLocation(location) == null) {
                coin.addCoinOnCurrentLocation(location);
            }
        }
    }

}
