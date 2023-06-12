package main.objects;

import main.objects.objectOnMap.GeneratorLoot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inventory extends JPanel {
    private JLabel inventoryName;
    private JPanel panel;
    private int currentSlot = 0;
    private int equipSlot;
    private ArrayList<JLabel> slotInventoryName;
    private ArrayList<GeneratorLoot.Loot> slotInventoryLoot;
    private GeneratorLoot.Loot loot;
    private JLabel slot;
    public Inventory() {
        this.slotInventoryName = new ArrayList<>();
        inventoryName = new JLabel("INVENTORY");

        this.slotInventoryLoot = new ArrayList<>();

        this.panel = new JPanel(new GridLayout(50,1));
        panel.add(inventoryName);
        add(panel);
    }
    public void addLootToInventory(GeneratorLoot.Loot loot) {
        slotInventoryLoot.add(loot);
        refreshInventory();
    }
    public void refreshInventory () {
        panel.removeAll();
        slotInventoryName.clear();
        panel.add(inventoryName);
        for (GeneratorLoot.Loot loot : slotInventoryLoot) {
            slotInventoryName.add(new JLabel(loot.name+loot.damage));
        }
        for (JLabel slot : slotInventoryName) {
            panel.add(slot);
        }
        String currentSlotText = null;
        try {
        currentSlotText = slotInventoryName.get(currentSlot).getText();
        slotInventoryName.get(currentSlot).setText("--->    " + currentSlotText);
        } catch (IndexOutOfBoundsException e) {}
    }
    public void currentSlotInventoryUp () {
        String currentSlotText = null;
        try {
            currentSlotText = slotInventoryName.get(currentSlot).getText();
        if (currentSlotText.startsWith("--->    ")) {
            currentSlotText = currentSlotText.substring(8);
        }
        slotInventoryName.get(currentSlot).setText(currentSlotText);
        currentSlot += slotInventoryName.size();
        currentSlot --;
        currentSlot %= slotInventoryName.size();
        currentSlotText = slotInventoryName.get(currentSlot).getText();
        slotInventoryName.get(currentSlot).setText("--->    " + currentSlotText);
        } catch (IndexOutOfBoundsException e) {}
    }
    public void currentSlotInventoryDown () {
        String currentSlotText = null;
        try {
            currentSlotText = slotInventoryName.get(currentSlot).getText();
        if (currentSlotText.startsWith("--->    ")) {
            currentSlotText = currentSlotText.substring(8);
        }
        slotInventoryName.get(currentSlot).setText(currentSlotText);
        currentSlot++;
        currentSlot %= slotInventoryName.size();
        currentSlotText = slotInventoryName.get(currentSlot).getText();
        slotInventoryName.get(currentSlot).setText("--->    " + currentSlotText);
        } catch (IndexOutOfBoundsException e) {}
    }
    public void setEquipSlot () {
        String equipSlotText = null;
        try {
            equipSlotText = slotInventoryName.get(equipSlot).getText();
            if (equipSlotText.endsWith("    ||")) {
                equipSlotText = equipSlotText.substring(0, equipSlotText.length() - 6);
            }
            slotInventoryName.get(equipSlot).setText(equipSlotText);
            equipSlot += slotInventoryName.size();
            equipSlot = currentSlot;
            equipSlotText = slotInventoryName.get(equipSlot).getText();
            slotInventoryName.get(equipSlot).setText(equipSlotText+"    ||");
        } catch (IndexOutOfBoundsException e) {}
        catch (NullPointerException e) {}
    }
    public int getDamageFromCurrentSlot () {
        return slotInventoryLoot.get(currentSlot).damage;
    }
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}
