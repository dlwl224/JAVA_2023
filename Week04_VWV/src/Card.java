import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BusinessCard {
    private Image backgroundImage;
    private String name;
    private String job;
    private String school;

    public BusinessCard() {
        // 배경 이미지 로드
        ImageIcon icon = new ImageIcon("dog.webp");
        backgroundImage = icon.getImage();

        // 명함 정보 설정
        name = "이지원";
        job = "학생";
        school = "덕성여자대학교";
    }

    public void draw(Graphics g) {
        // 배경 이미지 그리기
        g.drawImage(backgroundImage, 0, 0, null);

        // 텍스트 그리기
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(name, 50, 100);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString(job, 50, 130);
        g.drawString(school, 50, 160);
    }
}

public class Card extends JFrame {
    private JPanel contentPane;

    public Card() {
        setTitle("Business Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);

        contentPane = new JPanel() {
           
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBusinessCard(g);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setVisible(true);
    }

    public void drawBusinessCard(Graphics g) {
        BusinessCard businessCard = new BusinessCard();
        businessCard.draw(g);
    }

    public static void main(String[] args) {
        Card frame = new Card();
    }
}

