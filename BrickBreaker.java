import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrickBreaker extends JPanel implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BALL_DIAMETER = 20;
    private static final int BRICK_WIDTH = 50;
    private static final int BRICK_HEIGHT = 20;

    private Ball ball;
    private Brick brick;

    public BrickBreaker() {
        ball = new Ball(WIDTH / 2, HEIGHT / 2, BALL_DIAMETER);
        brick = new Brick(WIDTH / 2 - BRICK_WIDTH / 2, HEIGHT - 50, BRICK_WIDTH, BRICK_HEIGHT);

        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        ball.draw(g);
        brick.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        ball.move();

        if (ball.getX() <= 0 || ball.getX() + ball.getDiameter() >= WIDTH)
            ball.reverseX();

        if (ball.getY() <= 0 || ball.getY() + ball.getDiameter() >= HEIGHT)
            ball.reverseY();

        if (brick.intersects(ball))
            ball.reverseY();

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.add(new BrickBreaker());
        frame.setVisible(true);
    }
}
