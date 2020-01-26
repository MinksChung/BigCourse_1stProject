package gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

public class StartPage {
	private static JTextField textField;
	private static JTextField textField_1;

	public static void main(String[] args) {
		JFrame startPageFrame = new JFrame("채용정보검색프로그램");
		startPageFrame.setSize(900, 600);
		startPageFrame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 153, 255));
		panel_3.setBounds(472, 268, 255, 206);
		startPageFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtnPersenal = new JRadioButton("개인로그인");
		rdbtnPersenal.setBounds(13, 5, 105, 35);
		rdbtnPersenal.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(rdbtnPersenal);
		
		JRadioButton rdbtnCorper = new JRadioButton("기업로그인");
		rdbtnCorper.setBounds(127, 6, 105, 35);
		rdbtnCorper.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_3.add(rdbtnCorper);
		
		JLabel putIdTextLb = new JLabel("회 원 I D");
		putIdTextLb.setBounds(30, 72, 79, 27);
		putIdTextLb.setFont(new Font("굴림", Font.PLAIN, 18));
		panel_3.add(putIdTextLb);
		
		textField = new JTextField();
		textField.setBounds(115, 70, 127, 31);
		textField.setFont(new Font("굴림", Font.PLAIN, 18));
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("비밀번호 ");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(30, 111, 82, 27);
		panel_3.add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(115, 111, 127, 31);
		panel_3.add(textField_1);
		
		JButton signInBt = new JButton("SignUp");
		signInBt.setBounds(13, 168, 105, 28);
		panel_3.add(signInBt);
		
		JButton button = new JButton("SignIn");
		button.setBounds(130, 168, 105, 28);
		panel_3.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 884, 561);
		startPageFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("background.gif"));
		lblNewLabel.setBounds(0, 0, 884, 561);
		panel.add(lblNewLabel);
		
		
		startPageFrame.setVisible(true);
		
	}
}
