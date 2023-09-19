import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class DistanceConversion {
	

	public static void main(String argv[]) {
		JFrame frame = new JFrame("Mile->Km");
		
		JPanel panel=new JPanel();
		frame.add(panel);
		
		JLabel label1 =new JLabel("마일을 입력하시오:");
		JTextField field1= new JTextField(10);
		JLabel label2= new JLabel("->");
		JTextField field2 =new JTextField(10);
		JButton button = new JButton("변환");
		
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double miles = Double.parseDouble(field1.getText());
				double kilometers = miles*1.609344;
				field2.setText(String.format("%f", kilometers));
			}
		});
		
		
		frame.pack();
		frame.setVisible(true);
		

	}


}
