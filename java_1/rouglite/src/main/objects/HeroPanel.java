package main.objects;

import main.objects.objectOnMap.person.Hero;

import javax.swing.*;
import java.awt.*;

public class HeroPanel extends JPanel {
    private JLabel name;
    private JLabel lvl;
    private JLabel currentExp;
    private JLabel hp;
    private JLabel damage;
    private JLabel numberOfCoin;
    private Hero hero;
    public HeroPanel(Hero hero) {
        this.hero = hero;

        name = new JLabel("Name: " + hero.getName());
        lvl = new JLabel("lvl: " + hero.getLvl());
        currentExp = new JLabel("exp: " + hero.getCurrentExp());
        hp = new JLabel("HP: " + hero.getCurrentHp() + "/" + hero.getMaxHp());
        damage = new JLabel("Damage: " + hero.getDamage());
        numberOfCoin = new JLabel("numberOfCoin: " + hero.getNumberOfCoin());

        JPanel panel = new JPanel(new GridLayout(1,7));
        panel.add(name);
        panel.add(lvl);
        panel.add(currentExp);
        panel.add(hp);
        panel.add(damage);
        panel.add(numberOfCoin);
        add(panel);
    }
    public void updateHeroPanel () {
        name.setText("Name: " + hero.getName());
        lvl.setText("lvl: " + hero.getLvl());
        currentExp.setText("exp: " + hero.getCurrentExp());
        hp.setText("HP: " + hero.getCurrentHp() + "/" + hero.getMaxHp());
        damage.setText("Damage: " + hero.getDamage());
        numberOfCoin.setText("numberOfCoin: " + hero.getNumberOfCoin());
    }

}
