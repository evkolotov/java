package main.objects.objectOnMap;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

public class Wall extends ObjectOnMap {
    private int numberOfWallOnMap = 10;
    public Wall (ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //InitWallUseForCreateAllWallsOnMap
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
    }
    private Wall (int[] currentLocation, ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = '#';
        this.currentLocation = currentLocation;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
    }
    private void addCurrentWallOnMap () {
        listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
    }

    public void addOnMap() {
        //add wall along the edges of the map
        for (int i = 0; i<numberOfRowsMap; i++){
            for (int j = 0; j<numberOfColumnsMap; j++) {
                if (i==0 || j==0 || i==numberOfRowsMap-1 || j==numberOfColumnsMap-1) {
                    int[] currentLocation = new int[]{i, j};
                    if (listLocationAndObjectOnMap.hasObjectAtLocation(currentLocation) == null) {
                        Wall currentWall = new Wall(currentLocation, listLocationAndObjectOnMap);
                        currentWall.addCurrentWallOnMap();
                    }
                }
            }
        }
        //add random Wall
        for (int i = 0; i<numberOfWallOnMap; i++) {
            int startRows = Engine.getEngine().random.nextInt(2, numberOfRowsMap);
            int startColumns = Engine.getEngine().random.nextInt(2, numberOfColumnsMap);
            int numberOfRowsWall = Engine.getEngine().random.nextInt(3,10);
            int numberOfColumnsWall = Engine.getEngine().random.nextInt(3,10);
            for (int j = 0; j<numberOfRowsWall; j++) {
                for (int k = 0; k<numberOfColumnsWall; k++) {
                    int currentY = startRows+j;
                    int currentX = startColumns+k;
                    if (currentY < numberOfRowsMap-2 && currentX < numberOfColumnsMap-2) {
                        int[] currentLocation = new int[] {currentY,currentX};
                        if (listLocationAndObjectOnMap.hasObjectAtLocation(currentLocation) == null) {
                            Wall currentWall = new Wall(currentLocation, listLocationAndObjectOnMap);
                            currentWall.addCurrentWallOnMap();
                        }
                    }
                }
            }
        }
    }
}
