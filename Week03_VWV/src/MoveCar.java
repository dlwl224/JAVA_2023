import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MoveCar extends JFrame {
    private int carPositionX = 0; 
    private Image carImage; 
    public MoveCar() {
       
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadCarImage();

        JPanel panel = new JPanel();
        add(panel);

        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");

        panel.add(leftButton);
        panel.add(rightButton);

        leftButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                moveCarLeft();
            }
        });

        rightButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                moveCarRight();
            }
        });

        setVisible(true);
    }

    private void loadCarImage() {
        try {
            carImage = ImageIO.read(new File("c:\\car.png.png")); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moveCarLeft() {
        carPositionX -= 10; 
        repaint(); 
    }

    private void moveCarRight() {
        carPositionX += 10;
        repaint(); 
    }

   
    public void paint(Graphics g) {
        super.paint(g);
        drawCar(g);
    }

    private void drawCar(Graphics g) {
        if (carImage != null) {
            g.drawImage(carImage, carPositionX, 80, this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MoveCar());
    }
}

