package com.willmcintosh;

import java.awt.*;

public class HumanPaddle implements Paddle{
    double y, yVel;
    boolean upAccel, downAccel;
    final double FRICTION = 0.94d;
    int player, x;


    public HumanPaddle(int player) {
        upAccel = false; downAccel = false;
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
        if (upAccel) {
            yVel -= 2;
        }
        else if (downAccel) {
            yVel +=2;
        }
        else if (!upAccel && !downAccel) {
            yVel *= FRICTION;
        }

        // slow down paddle once it reaches top speed of 5
        if (yVel >= 5) {
            yVel = 5;
        }
        else if (yVel <= -5) {
            yVel = -5;
        }
        y += yVel;

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

    public void setUpAccel (boolean input) {
        upAccel = input;
    }

    public void setDownAccel (boolean input) {
        downAccel = input;
    }

    @Override
    public int getY() {
        return (int) y;
    }
}
