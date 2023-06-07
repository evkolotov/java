package main.objects.objectOnMap;

import java.util.HashSet;
import java.util.Random;

public class Wall extends Object {
    private int numberOfWallOnMap = 10;
    private int numberOfRowsMap;
    private int numberOfColumnsMap;

    public Wall (int numberOfRowsMap, int numberOfColumnsMap) {
        this.numberOfWallOnMap = numberOfWallOnMap;
        this.numberOfRowsMap = numberOfRowsMap;
        this.numberOfColumnsMap = numberOfColumnsMap;
        this.charOnMap = '#';
        this.location = new HashSet<int[]>();
        //add wall along the edges of the map
        for (int i = 0; i<numberOfRowsMap; i++){
            for (int j = 0; j<numberOfColumnsMap; j++) {
                if (i==0 || j==0 || i==numberOfRowsMap-1 || j==numberOfColumnsMap-1) {
                    location.add(new int[] {i,j});
                }
            }
        }
        //add random wall
        Random random = new Random();
        for (int i = 0; i<numberOfWallOnMap; i++) {
            int startRows = random.nextInt(2, numberOfRowsMap);
            int startColumns = random.nextInt(2, numberOfColumnsMap);
            int numberOfRowsWall = random.nextInt(3,10);
            int numberOfColumnsWall = random.nextInt(3,10);
            for (int j = 0; j<numberOfRowsWall; j++) {
                for (int k = 0; k<numberOfColumnsWall; k++) {
                    int currentY = startRows+j;
                    int currentX = startColumns+k;
                    if (currentY < numberOfRowsMap-2 && currentX < numberOfColumnsMap-2) {
                        location.add(new int[] {currentY,currentX});
                    }
                }
            }
        }

    }

}
