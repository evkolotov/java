package main.objects;

import main.objects.objectOnMap.ObjectOnMap;

public interface ObjectOnMapChecker <T> {
    public T hasObjectAtLocation(int[] location);
}
