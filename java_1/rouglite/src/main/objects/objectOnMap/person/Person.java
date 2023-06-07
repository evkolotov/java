package main.objects.objectOnMap.person;

import main.objects.InteractionLogic;
import main.objects.objectOnMap.Object;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Person extends Object implements InteractionLogic {
    public String name;
    public int hp;
    public int damage;
    public HashMap<Character, Runnable> action;






}
