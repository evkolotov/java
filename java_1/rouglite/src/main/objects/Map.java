package main.objects;

import main.engine.Engine;

import java.util.HashSet;

public class Map {
    private char [][] map;
    private int numberOfRowsMap;
    private int numberOfColumnsMap;
    private ListObjectOnMap listObjectOnMap;

    public Map(ListObjectOnMap listObjectOnMap) {
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
        this.listObjectOnMap = listObjectOnMap;
        this.map = new char [numberOfRowsMap][numberOfColumnsMap];
    }
    public void generateMap () {
        for (int i=0; i<numberOfRowsMap; i++) {
            for (int j=0; j<numberOfColumnsMap; j++) {
                map[i][j] = '.';
            }
        }
        for(Character key : listObjectOnMap.getListObjectOnMap().keySet()) {
            HashSet<int[]> value =  listObjectOnMap.getListObjectOnMap().get(key);
            for (int[] arr: value) {
                map[arr[0]][arr[1]] = key;
            }
            System.out.println();
        }
        //heroForwardOnMap
        for (int[] locationHero : listObjectOnMap.getListObjectOnMap().get('@')) {
            map[locationHero[0]][locationHero[1]] = '@';
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
