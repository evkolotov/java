package main.objects.objectOnMap;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

public class GeneratorLoot extends ObjectOnMap{
    private ListLocationAndObjectOnMap listLocationAndObjectOnMap;
    public GeneratorLoot(ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
    }
    public void generateLootOnLocation (int[] location) {
        int damage = Engine.getEngine().random.nextInt(5,25);
        Loot loot = new Loot(location, damage, listLocationAndObjectOnMap);
        loot.addOnMap();
    }

    @Override
    public void addOnMap() {

    }
    public class Loot extends ObjectOnMap{
        public String name;
        public int damage;
        public Loot (int[] currentLocation, int damage, ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
            this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
            this.charOnMap = '-';
            this.currentLocation = currentLocation;
            this.damage = damage;
            this.name = "sword +";
        }
        @Override
        public void addOnMap() {
            listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
        }
    }
}
