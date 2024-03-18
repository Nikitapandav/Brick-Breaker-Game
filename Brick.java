import java.awt.Color;
import java.awt.Graphics;

public class Brick {
    private int x, y, width, height;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public boolean intersects(Ball ball) {
        return ball.getX() + ball.getDiameter() >= x && ball.getX() <= x + width &&
                ball.getY() + ball.getDiameter() >= y && ball.getY() <= y + height;
    }
}
