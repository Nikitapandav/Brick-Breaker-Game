import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int x, y, diameter, xSpeed, ySpeed;

    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        xSpeed = 2;
        ySpeed = 2;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void reverseX() {
        xSpeed = -xSpeed;
    }

    public void reverseY() {
        ySpeed = -ySpeed;
    }
}
