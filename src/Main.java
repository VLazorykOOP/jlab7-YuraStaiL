import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int windowWidth = 800;
        int speedV = 2;
        JFrame frame = new JFrame("Car Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, 200);
        frame.setLayout(null);

        int carSize = 50;
        Car car1 = new Car("Car 1", speedV, windowWidth, carSize, 3000);
        Car car2 = new Car("Car 2", speedV, windowWidth, carSize, 0);

        frame.add(car1.getCarLabel());
        frame.add(car2.getCarLabel());

        frame.setVisible(true);

        new Thread(car1).start();
        new Thread(car2).start();
    }
}