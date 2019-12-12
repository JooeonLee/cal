import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Cal extends JFrame implements ActionListener {
	private JTextField tf;
	private JPanel p1, p2;
	private JButton[] btn;
	private String[] arr = { "<-", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0",
			"00", ".", "=" };

	private String fullText = null;
	private String inputText = null;

	public Cal() {
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		init();

		setVisible(true);
	}

	private void init() {
		// 패널 세팅
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(5, 4, 1, 1));
		p1.setPreferredSize(new Dimension(400, 50));

		// 컴포넌트 세팅
		tf = new JTextField();
		p1.add(tf);

		btn = new JButton[20];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(arr[i]);
			p2.add(btn[i]);
			btn[i].addActionListener(this);
		}

		// JFrame 세팅
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fullText = tf.getText();
		inputText = e.getActionCommand();

		// <-, CE, C, = 걸러내고 텍스트필드에 데이터 뿌려주기
		if (!(inputText.equals("<-") || inputText.equals("CE") || inputText.equals("C") || inputText.equals("="))) {
			fullText += inputText;
			tf.setText(fullText);
		}

		switch (inputText) {
		case "<-":
			fullText = fullText.substring(0, fullText.length() - 1);
			tf.setText(fullText);
			break;

		case "CE":
			tf.setText("");
			break;

		case "C":
			tf.setText("");
			break;

		case "=":
			Eval3 eval3 = new Eval3();
			double result = eval3.fullTextParsing(fullText);
			tf.setText(result + "");
			break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cal();
	}

}
