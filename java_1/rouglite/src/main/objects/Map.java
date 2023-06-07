package main.objects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Map {
    private char [][] map;
    private int numberOfRows;
    private int numberOfColumns;
    private HashMap listObjectOnMap;

    public Map(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = new char [numberOfRows][numberOfColumns];
    }
    public void generateMap (HashMap<Character, HashSet<int[]>> listObjectOnMap) {
        for (int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColumns; j++) {
                map[i][j] = '.';
            }
        }
        this.listObjectOnMap = listObjectOnMap;
        for(Character key : listObjectOnMap.keySet()) {
            HashSet<int[]> value = listObjectOnMap.get(key);
            for (int[] arr: value) {
                map[arr[0]][arr[1]] = key;
            }
            System.out.println();
        }
    }
    public void renderMap () {
        for (int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColumns; j++) {
                System.out.print(map[i][j]);
                if (j != numberOfColumns-1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }






}
