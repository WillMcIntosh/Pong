package com.willmcintosh;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {

    public final int WIDTH = 700, HEIGHT = 500;

    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted;
    Graphics gfx;
    Image img;


    public void init() {
        this.resize(WIDTH, HEIGHT);
        gameStarted = false;
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AIPaddle(2, b1);
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();

    }

    // paint onto offscreen buffer and then display to screen
    // to prevent flickering effect

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0,0, WIDTH, HEIGHT);

        // if ball goes off screen, display a game over
        if (b1.getX() < -10 || b1.getX() > 710) {
            gfx.setColor(Color.red);
            gfx.drawString("GAME OVER", 335, 250);
        }
        else {
            p1.draw(gfx);
            b1.draw(gfx);
            p2.draw(gfx);
        }

        if (!gameStarted) {
            gfx.setColor(Color.white);
            gfx.drawString("PONG!", 335, 100);
            gfx.drawString("Press Enter to Begin...", 290, 130);
        }

        g.drawImage(img, 0, 0, this);

    }

    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void run() {
        for (;;){
            if (gameStarted) {
                p1.move();
                p2.move();
                b1.move();
                b1.checkPaddleCollision(p1, p2);
            }


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
        else if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
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
