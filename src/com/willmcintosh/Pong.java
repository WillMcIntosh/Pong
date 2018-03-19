package com.willmcintosh;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {

    public final int WIDTH = 700, HEIGHT = 500;

    Thread thread;
    HumanPaddle p1;


    public void init() {
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);

        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);
        p1.draw(g);
    }

    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void run() {
        for (;;){

            p1.move();

            // infinite loop to run game
            // pause every 10 ms after a repaint

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        }

    }
}
