package main.objects.objectOnMap.person;

import main.objects.InteractionLogic;
import main.objects.objectOnMap.ObjectOnMap;

import java.util.HashMap;

public abstract class Person extends ObjectOnMap implements InteractionLogic {
    public int[] newLocation;
    public HashMap<Character, Runnable> action;
    public boolean checkExistence () {
        return listLocationAndObjectOnMap.checkObjectOnList(this);
    }


}
