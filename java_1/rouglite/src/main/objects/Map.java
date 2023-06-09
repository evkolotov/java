package main.objects;

import main.engine.Engine;
import main.objects.objectOnMap.ObjectOnMap;

import java.util.HashMap;

public class Map <T extends ObjectOnMap>  {
    private char [][] map;
    private int numberOfRowsMap;
    private int numberOfColumnsMap;
    private ListLocationAndObjectOnMap listLocationAndObjectOnMap;

    public Map(ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.map = new char [numberOfRowsMap][numberOfColumnsMap];
    }
    public void generateMap () {

        for (int i=0; i<numberOfRowsMap; i++) {
            for (int j=0; j<numberOfColumnsMap; j++) {
                map[i][j] = '.';
            }
        }

        HashMap<int[], T> locationAndObjectOnMap = listLocationAndObjectOnMap.getListLocationAndObjectOnMap();
        for (int[] key : locationAndObjectOnMap.keySet()) {
            map[key[0]][key[1]] = locationAndObjectOnMap.get(key).charOnMap;
        }

    }
    public void renderMap () {
        for (int i=0; i<numberOfRowsMap; i++) {
            for (int j=0; j<numberOfColumnsMap; j++) {
                System.out.print(map[i][j]);
                if (j != numberOfColumnsMap-1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

}
