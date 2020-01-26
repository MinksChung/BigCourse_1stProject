package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gui.*;
public class UserGUI {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	static int idoverlap = 1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public UserGUI() {
		JFrame f = new JFrame();
		f.getContentPane().setFont(new Font("굴림", Font.BOLD, 27));
		f.setTitle("회원가입");
		f.setSize(900, 600);
		f.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("신규 회원가입");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 45));
		lblNewLabel.setBounds(0, 0, 315, 71);
		f.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("채용정보검색프로그램");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel_1.setBounds(508, 2, 370, 72);
		f.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_2.setBounds(173, 113, 153, 52);
		f.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("비밀번호");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_3.setBounds(146, 164, 197, 52);
		f.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("비밀번호 확인");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_4.setBounds(129, 219, 229, 46);
		f.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("이름");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_5.setBounds(171, 268, 155, 52);
		f.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("휴대폰번호");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_6.setBounds(114, 319, 263, 52);
		f.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("이메일주소");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_7.setBounds(114, 370, 252, 52);
		f.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("주소");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_8.setBounds(187, 421, 128, 52);
		f.getContentPane().add(lblNewLabel_8);
		JLabel l1 = new JLabel("비밀번호확인");

		
		
		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.BOLD, 20));
		t1.setBounds(389, 113, 370, 52);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new HintTextField("영문,숫자,기호만 가능합니다."); // 비밀번호치면 안보이게 해주는거 textfield말고 패스워드필드쓰면됨
		t2.setFont(new Font("굴림", Font.BOLD, 20));
		t2.setBounds(389, 164, 370, 52);
		f.getContentPane().add(t2);

		t3 = new HintTextField("한번 더 입력해주세요.");
		t3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (t2.getText().equals(t3.getText()) && t3.getText().equals(t2.getText())) {
					l1.setText("확인되었습니다.");
				} else {
					l1.setText("다시입력하세요.");
				}
			}
		});
		t3.setFont(new Font("굴림", Font.BOLD, 20));
		t3.setBounds(389, 216, 370, 52);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.BOLD, 20));
		t4.setBounds(389, 268, 370, 52);
		f.getContentPane().add(t4);
		t4.setColumns(10);

		t5 = new HintTextField("' - '를 제외하고 입력해주세요.");
		t5.setFont(new Font("굴림", Font.BOLD, 20));
		t5.setBounds(389, 319, 370, 52);
		f.getContentPane().add(t5);
		t5.setColumns(10);

		t6 = new JTextField();
		t6.setFont(new Font("굴림", Font.BOLD, 20));
		t6.setBounds(389, 370, 370, 52);
		f.getContentPane().add(t6);
		t6.setColumns(10);

		t7 = new JTextField();
		t7.setFont(new Font("굴림", Font.BOLD, 20));
		t7.setBounds(389, 421, 370, 52);
		f.getContentPane().add(t7);
		t7.setColumns(10);

		JButton b3 = new JButton("가입하기");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = t1.getText();
				String pw = t2.getText();
				String pw2 = t3.getText();
				String name = t4.getText();
				String tel = t5.getText();
				String email = t6.getText();
				String addr = t7.getText();

				UserDAO db = new UserDAO();
				UserDTO dto = new UserDTO();
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setTel(tel);
				dto.setEmail(email);
				dto.setAddr(addr);
				if (id.equals("")) {
					idoverlap = 0; // 아이디가 빈칸이면
				}
				try {
					if (idoverlap == 1 && l1.getText().equals("확인되었습니다.")) {
						db.insert(dto);
						//JOptionPane.showMessageDialog(null, "회원가입완료!");
						f.dispose();
					} else {
						//JOptionPane.showMessageDialog(null, "가입불가");
					}
				} catch (Exception e) {
				}

			}
		});
		b3.setFont(new Font("굴림", Font.BOLD, 24));
		b3.setBackground(new Color(32, 178, 170));
		b3.setBounds(329, 488, 252, 44);
		f.getContentPane().add(b3);

		JButton b1 = new JButton("ID중복검사");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = t1.getText();
				UserDAO dao = new UserDAO();
				try {
					idoverlap = dao.overlap(data);
					if (idoverlap == 0) {
						//JOptionPane.showMessageDialog(null, "이미사용중인ID입니다. 다시입력해주세요.");
					} else {
						//JOptionPane.showMessageDialog(null, "사용가능한 ID입니다");
					}
				}

				catch (Exception e2) {
				}
				System.out.println("4. sql문 실행요청 ok...");

			}
		});
		b1.setBackground(new Color(0, 139, 139));
		b1.setFont(new Font("굴림", Font.PLAIN, 12));
		b1.setBounds(771, 133, 97, 23);
		f.getContentPane().add(b1);

		l1.setForeground(Color.RED);
		l1.setBackground(new Color(0, 128, 128));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(771, 232, 97, 23);
		f.getContentPane().add(l1);

		f.setVisible(true);
	}
}
