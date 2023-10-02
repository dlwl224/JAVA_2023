import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class BusinessCard extends JPanel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.white);
		String name="이지원";
		String major="사이버보안전공";
		String uni="덕성여자대학교";
		
		
		g.setColor(Color.black);
	    int textX = 300;
	    int textY = 50;

	       
	    g.drawString("Name: " + name, textX, textY);
	    g.drawString("Major: " + major, textX, textY + 20);
	    g.drawString("Univer: " + uni, textX, textY + 40);
	    
	    int imageX = 50;
        int imageY = 50;
        int imageWidth=70;
        int imageHeight=70;
        

        try {
            BufferedImage originalImage = ImageIO.read(new File("dog.jpg"));
            BufferedImage scaledImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = scaledImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, imageWidth, imageHeight, null);
            g2d.dispose();
            g.drawImage(scaledImage, imageX, imageY, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyFrameCustomName extends JFrame {
    public MyFrameCustomName() {
        setTitle("Business Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);

        BusinessCard businessCard = new BusinessCard();
        add(businessCard);

        setVisible(true);
    }
}
public class Card {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			MyFrameCustomName F= new MyFrameCustomName();
		});
	}

}

