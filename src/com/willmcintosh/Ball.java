package com.willmcintosh;

import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball() {
        x = 350;
        y= 250;
        xVel = -2;
        yVel = 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        // create a 20 x 20 circle
        // draws a circle from top left corner and we want (x,y) to
        // represent the center of the circle
        g.fillOval((int)x - 10, (int)y - 10, 20, 20);
    }

    public void move() {
        x += xVel;
        y += yVel;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }
}
