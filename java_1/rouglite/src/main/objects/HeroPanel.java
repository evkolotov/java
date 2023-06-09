package main.objects;

import main.objects.objectOnMap.person.Hero;

import javax.swing.*;

public class HeroPanel extends JPanel {
    private Hero hero;
    public HeroPanel(Hero hero) {
        this.hero = hero;
        JLabel label = new JLabel("[StatusBar] [Name: ");
        add(label);
        label = new JLabel(hero.name);
        add(label);
        label = new JLabel("] [lvl: ");
        add(label);
        label = new JLabel(String.valueOf(hero.lvl));
        add(label);
        label = new JLabel("] [exp: ");
        add(label);
        label = new JLabel(String.valueOf(hero.currentExp));
        add(label);
        label = new JLabel("] [HP: ");
        add(label);
        label = new JLabel(String.valueOf(hero.currentHp));
        add(label);
    }
}
