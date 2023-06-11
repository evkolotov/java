package main.objects;

import main.engine.Engine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class ArrowKeys extends JPanel implements KeyListener  {

    private char[][] myArray;
    private int height;
    private int width;
    private Map map;
    private int tileSize = 20;
    public ArrowKeys(Map map) {
        super(new BorderLayout());
        this.map = map;
        this.myArray = map.getMap();

        addKeyListener(this);

        height = myArray.length;
        width = myArray[0].length;
        setPreferredSize(new Dimension(width * tileSize, height * tileSize));
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            Engine.getEngine().inputChar = 'a';
            Engine.getEngine().inputProcessed = true; // установка флага в true
        } else if (key == KeyEvent.VK_RIGHT) {
            Engine.getEngine().inputChar = 'd';
            Engine.getEngine().inputProcessed = true; // установка флага в true
        } else if (key == KeyEvent.VK_UP) {
            Engine.getEngine().inputChar = 'w';
            Engine.getEngine().inputProcessed = true; // установка флага в true
        } else if (key == KeyEvent.VK_DOWN) {
            Engine.getEngine().inputChar = 's';
            Engine.getEngine().inputProcessed = true; // установка флага в true
        } else if (key == KeyEvent.VK_I) {
            Engine.getEngine().inputChar = 'i';
            Engine.getEngine().inputProcessed = true; // установка флага в true
        }
        synchronized (Engine.getEngine()) {
            Engine.getEngine().notify(); // оповещение ожидающего потока, что флаг изменился
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        // not used
    }

    public void keyReleased(KeyEvent e) {
        // not used
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Monospaced", Font.PLAIN, tileSize);
        g.setFont(font);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                g.drawString(Character.toString(myArray[i][j]), j * tileSize, (i + 1) * tileSize);
            }
        }
    }

}
