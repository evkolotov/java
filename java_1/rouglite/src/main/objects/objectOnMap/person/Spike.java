package main.objects.objectOnMap.person;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;
import main.objects.objectOnMap.ObjectOnMap;

public class Spike extends ObjectOnMap {
    private int numberOfSpikeOnMap = 10;
    public Spike (ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //InitWallUseForCreateAllSpikeOnMap
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
    }
    private Spike (int[] currentLocation, ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = 's';
        this.currentLocation = currentLocation;
        this.damage = 10;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
    }
    private void addCurrentSpikeOnMap () {
        listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
    }
    public void addOnMap() {
        //add random Spike
        int counter = 0;
        while (counter != numberOfSpikeOnMap) {
            int currentY = Engine.getEngine().random.nextInt(numberOfRowsMap);
            int currentX = Engine.getEngine().random.nextInt(numberOfColumnsMap);
            int[] currentLocation = new int[] {currentY,currentX};
            if (listLocationAndObjectOnMap.hasObjectAtLocation(currentLocation) == null) {
                Spike currentSpike = new Spike(currentLocation, listLocationAndObjectOnMap);
                currentSpike.addCurrentSpikeOnMap();
                counter++;
            }
        }
    }
}
