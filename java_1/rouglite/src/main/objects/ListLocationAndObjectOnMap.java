package main.objects;

import main.objects.objectOnMap.GeneratorLoot;
import main.objects.objectOnMap.ObjectOnMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListLocationAndObjectOnMap <T extends ObjectOnMap>  implements ObjectOnMapChecker{
    private HashMap<IntArrayKey, T> listLocationAndObjectOnMap;
    public ListLocationAndObjectOnMap() {
        this.listLocationAndObjectOnMap = new HashMap<>();
    }
    public void addObjectToListLocationAndObjectOnMap(int [] location, T object) {
        listLocationAndObjectOnMap.put(new IntArrayKey(location), object);
    }
    public void removeObjectFromListLocationAndObjectOnMap(int [] location) {
        listLocationAndObjectOnMap.remove(new IntArrayKey(location));
    }
    @Override
    public T hasObjectAtLocation(int[] location) {
        return listLocationAndObjectOnMap.get(new IntArrayKey(location));
    }
    public ArrayList<int[]> getListLocationByChar(char charToSearch) {
        ArrayList<int[]> result = new ArrayList<>();
        for (IntArrayKey key : listLocationAndObjectOnMap.keySet()) {
            if (listLocationAndObjectOnMap.get(key).charOnMap == charToSearch) {
                result.add(key.array);
            }
        }
        return result;
    }
    public T getLootAroundLocation(int [] location) {
        ArrayList<int[]> locationAround = new ArrayList<>();
        locationAround.add(new int[] {location[0]+1, location[1]});
        locationAround.add(new int[] {location[0]-1, location[1]});
        locationAround.add(new int[] {location[0], location[1]+1});
        locationAround.add(new int[] {location[0], location[1]-1});
        for (int[] key : locationAround) {
             T objectAtLocation = hasObjectAtLocation(key);
            if (objectAtLocation instanceof GeneratorLoot.Loot) {
                return objectAtLocation;
            }
        }
        return null;
    }

    static class IntArrayKey {
        private final int[] array;
        IntArrayKey(int[] array) {
            this.array = array;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntArrayKey that = (IntArrayKey) o;

            return Arrays.equals(array, that.array);
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }
    public boolean checkObjectOnList (T object) {
        return listLocationAndObjectOnMap.containsValue(object);
    }
}

