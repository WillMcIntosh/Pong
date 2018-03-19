package com.willmcintosh;

import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball() {
        x = 350;
        y= 250;
        xVel = getRandomSpeed() * getRandomDirection();
        yVel = getRandomSpeed() * getRandomDirection();
    }

    // give ball random starting x and y velocities
    public double getRandomSpeed() {
        return (Math.random() * 3 + 2);
    }

    public int getRandomDirection() {
        int rand = (int)(Math.random() * 2);
        if (rand == 1) {
            return 1;
        }
        else {
            return -1;
        }
    }


    public void draw(Graphics g) {
        g.setColor(Color.white);
        // create a 20 x 20 circle
        // draws a circle from top left corner and we want (x,y) to
        // represent the center of the circle
        g.fillOval((int)x - 10, (int)y - 10, 20, 20);
    }

    public void checkPaddleCollision(Paddle p1, Paddle p2) {
        // when ball is at x = 50, it is touching the left paddle
        if (x <=50) {
            if (y >= p1.getY() && y <= p1.getY() + 80) {
                xVel = -xVel;
            }
        }
        else if (x >= 650) {
            if (y >= p2.getY() && y <= p2.getY() + 80) {
                xVel = -xVel;
            }
        }
    }

    public void move() {
        x += xVel;
        y += yVel;

        if (y < 10) {
            yVel = -yVel;
        }
        if (y > 490) {
            yVel = -yVel;
        }
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void setxVel(double xVel) {
        this.xVel = xVel;
    }

    public void setyVel(double yVel) {
        this.yVel = yVel;
    }
}
