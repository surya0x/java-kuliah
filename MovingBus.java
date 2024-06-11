package movingbus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBus extends JPanel implements ActionListener {

    private Timer timer;

    private int carX = 0;
    private int carY = 300;
    private int cloudX = 0;
    private int cloudY = 50;
    private int cloudX2 = 500;
    private int cloudY2 = 75;
    private int cloudSpeed = 1;
    private int[] backgroundMountainXPoints = {-100, 0, 100, 200, 300, 400, 500, 600, 700, 800, 900};
    private int[] backgroundMountainYPoints = {280, 230, 255, 205, 280, 230, 255, 205, 280, 230, 280};
    

    public MovingBus() {
        timer = new Timer(10, this); // Set timer delay to 10ms
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawRoad(g);
        drawCar(g);
       
    }
    

    private void drawBackground(Graphics g) {
        // Draw sky
        g.setColor(new Color(135, 206, 235)); // Sky blue color
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw clouds
        g.setColor(Color.WHITE);
        g.fillOval(cloudX, cloudY, 50, 30);
        g.fillOval(cloudX + 30, cloudY + 10, 40, 20);
        g.fillOval(cloudX + 60, cloudY, 50, 30);
        
        // Draw clouds
        g.setColor(Color.WHITE);
        g.fillOval(cloudX, cloudY, 60, 40);
        g.fillOval(cloudX + 40, cloudY + 20, 50, 30);
        g.fillOval(cloudX + 70, cloudY, 60, 40);

        // Draw another set of clouds
        g.fillOval(cloudX2, cloudY2, 60, 40);
        g.fillOval(cloudX2 + 40, cloudY2 + 15, 50, 25);
        g.fillOval(cloudX2 + 80, cloudY2, 60, 40);
        
        // Draw another set of clouds
        g.fillOval(cloudX2, cloudY2, 70, 50);
        g.fillOval(cloudX2 + 60, cloudY2 + 20, 60, 30);
        g.fillOval(cloudX2 + 100, cloudY2, 70, 50);

        // Draw mountains
        g.setColor(new Color(139, 69, 19)); // Brown color for mountains
        int[] mountainXPoints = {0, 100, 200, 300, 400, 500, 600, 700, 800};
        int[] mountainYPoints = {400, 350, 375, 325, 400, 350, 375, 325, 400};
        g.fillPolygon(mountainXPoints, mountainYPoints, mountainXPoints.length);

        // Draw additional mountains in the background
        int[] backgroundMountainXPoints = {-100, 0, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        int[] backgroundMountainYPoints = {450, 400, 425, 375, 450, 400, 425, 375, 450, 400, 450};
        g.fillPolygon(backgroundMountainXPoints, backgroundMountainYPoints, backgroundMountainXPoints.length);

        // Draw grass
        g.setColor(new Color(34, 139, 34)); // Forest green color
        g.fillRect(0, getHeight() / 2, getWidth(), getHeight() / 2);

        // Draw sun
        g.setColor(Color.ORANGE);
        g.fillOval(getWidth() -100, 50, 80, 80);
    }

    private void drawRoad(Graphics g) {
        // Draw the road
        g.setColor(Color.GRAY);
        g.fillRect(0, carY + 20, getWidth(), 60);

        // Draw lane markers
        g.setColor(Color.WHITE);
        for (int i = 0; i < getWidth(); i += 40) {
            g.fillRect(i, carY + 45, 20, 5);
        }
    }

    private void drawCar(Graphics g) {
        // Draw the body of the car
        g.setColor(Color.RED);
        g.fillRect(carX, carY, 60, 30);

        // Draw the windows
        g.setColor(Color.WHITE);
        g.fillRect(carX + 10, carY + 5, 15, 10);
        g.fillRect(carX + 35, carY + 5, 15, 10);
        
        // Draw additional mountains in the background
        g.setColor(new Color(139, 69, 19)); // Brown color for mountains
        g.fillPolygon(backgroundMountainXPoints, backgroundMountainYPoints, backgroundMountainXPoints.length);

        // Draw the wheels
        g.setColor(Color.BLACK);
        g.fillOval(carX + 5, carY + 25, 15, 15);
        g.fillOval(carX + 40, carY + 25, 15, 15);
        
    }


@Override
    public void actionPerformed(ActionEvent e) {
        carX += 2; // Move car to the right faster
        if (carX > getWidth()) {
            carX = -60; // Reset car position if it moves out of the window
        }

        cloudX += cloudSpeed; // Move clouds to the right
        cloudX2 += cloudSpeed; // Move second set of clouds to the right
        if (cloudX > getWidth()) {
            cloudX = -150; // Reset cloud position if it moves out of the window
        }
        if (cloudX2 > getWidth()) {
            cloudX2 = -200; // Reset second set of clouds position if it moves out of the window
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Bus and Car Animation");
        MovingBus movingBus = new MovingBus();
        frame.add(movingBus);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}