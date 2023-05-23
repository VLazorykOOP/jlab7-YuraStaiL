import javax.swing.*;
import java.awt.*;

class Car implements Runnable {
    private int speed;
    private int direction = 1;
    private int position = 0;
    private int limit;
    private JLabel carLabel;
    private int carSize;
    private long delay;

    public Car(String name, int speed, int limit, int carSize, long delay) {
        this.speed = speed;
        this.limit = limit - carSize;
        this.carSize = carSize;
        this.carLabel = new JLabel(name);
        this.carLabel.setBounds(position, 50, carSize, carSize);
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            SwingUtilities.invokeLater(() -> {
                if (position >= limit && direction == 1) {
                    direction *= -1;
                }
                else if (position <= 0 && direction == -1) {
                    direction *= -1;
                }
                position += speed * direction;
                carLabel.setLocation(position, 50);
            });

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public JLabel getCarLabel() {
        return carLabel;
    }
}