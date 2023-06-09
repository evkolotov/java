package main.objects.objectOnMap;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

public class Teleport extends ObjectOnMap {
    private int numberOfTeleportOnMap = 5;
    public Teleport (ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //InitWallUseForCreateAllTeleportOnMap
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
    }
    private Teleport (int[] currentLocation, ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = 't';
        this.currentLocation = currentLocation;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
    }
    private void addCurrentTeleportOnMap () {
        listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
    }
    public void addOnMap() {
        //add random Spike
        int counter = 0;
        while (counter != numberOfTeleportOnMap) {
            int currentY = Engine.getEngine().random.nextInt(numberOfRowsMap);
            int currentX = Engine.getEngine().random.nextInt(numberOfColumnsMap);
            int[] currentLocation = new int[] {currentY,currentX};
            if (listLocationAndObjectOnMap.hasObjectAtLocation(currentLocation) == null) {
                Teleport currentTeleport = new Teleport(currentLocation, listLocationAndObjectOnMap);
                currentTeleport.addCurrentTeleportOnMap();
                counter++;
            }
        }
    }

}
