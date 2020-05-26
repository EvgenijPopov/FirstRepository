package com.popov.homework.arcade.arcade;

import java.awt.*;
import java.util.Random;

public class FlyButton extends Button {
    private int dx;
    private int dy;

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public FlyButton(int width, int height, Color color) {
        Random random = new Random();
        this.setBounds(400, 400, width, height);
        this.setBackground(color);
        do {
            this.dx = -8 + random.nextInt(17); // скорость по оси х
        } while (this.getDx() == 0);
        this.dy = 5 + random.nextInt(5); // скорость по оси у
    }

    public boolean move() {
        setLocation(getX() + getDx(), getY() + getDy());
        Point p = getLocation();
        // reflection
        if (p.getX() >= 740 || p.getX() <= 0) {
            setDx(-1 * getDx());
        } else if (p.getY() >= 740 || p.getY() <= 0) {
            setDy(-1 * getDy());
            if (p.getY() >= 740) {
                return false;
            }
        }
        return true;
    }
}
