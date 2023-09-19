import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JFrame;

public class MemberInfo extends JFrame{
	public MemberInfo()
	{
		setSize(500,300);
		JPanel panel = new JPanel();
		add(panel);
		
		
		panel.add(new JLabel("이름     "));
		panel.add(new JTextField(20));
		panel.add(new JLabel("패스워드  "));
		panel.add(new JTextField(20));
		panel.add(new JLabel("이메일 주소"));
		panel.add(new JTextField(20));
		panel.add(new JLabel("전화번호   "));
		panel.add(new JTextField(20));
		
		JButton regis=new JButton("등록하기");
		panel.add(regis);
		
		JButton cancel = new JButton("취소");
		panel.add(cancel);
		
		setVisible(true);
	}


	public static void main(String[] args) {
		MemberInfo I = new MemberInfo();

	}

}
