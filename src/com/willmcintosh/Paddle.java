package com.willmcintosh;

import java.awt.*;

public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}

// might be better to use an abstract class with inheritance