package main.objects.objectOnMap.person.Enemy;

import main.engine.Engine;
import main.objects.InteractionLogic;
import main.objects.ListObjectOnMap;
import main.objects.objectOnMap.person.Person;

import java.util.HashSet;
import java.util.Random;

public abstract class Enemy extends Person implements InteractionLogic {
    public abstract void addOnMap () ;
    public abstract void action () ;
    @Override
    public boolean iterationLogic(Character currentCharOnMap, int[] newLocation) {
        return false;
    }

}
