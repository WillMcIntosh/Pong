package com.willmcintosh;

import java.awt.*;

public class AIPaddle implements Paddle{
    double y, yVel;
    boolean upAccel, downAccel;
    final double FRICTION = 0.94d;
    int player, x;
    Ball b1;


    public AIPaddle(int player, Ball b) {
        upAccel = false; downAccel = false;
        b1 = b;
        y = 210; yVel = 0;
        if (player ==1) {
            x = 20;
        }
        else {
            x = 660;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int) y, 20, 80);
    }

    @Override
    public void move() {
        // center AI paddle on Y value of ball
        y = b1.getY() -40;


        // stop paddle from going off screen
        if (y < 0) {
            y = 0;
        }
        // paddle is 80 tall, applet is 500 in height
        // paddle position is relative to top left corner
        if (y > 420) {
            y = 420;
        }



    }


    @Override
    public int getY() {
        return (int) y;
    }
}
