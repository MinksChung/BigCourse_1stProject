
	package user;


	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;


	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;


	import gui.HintTextField;


	public class UserUpdate {
	    private JTextField t2;
	    private JTextField t1;
	    private JTextField t3;


	    public UserUpdate(UserDTO user) {
	        JFrame f = new JFrame();
	        f.setTitle("회원정보수정");
	        f.setSize(900, 600);
	        f.getContentPane().setLayout(null);


	        JLabel l1 = new JLabel("현재ID");
	        l1.setBounds(97, 52, 177, 64);
	        l1.setFont(new Font("굴림", Font.BOLD, 55));
	        f.getContentPane().add(l1);


	        t1 = new JTextField();
	        t1.setBounds(320, 49, 506, 70);
	        t1.setFont(new Font("굴림", Font.BOLD, 55));
	        f.getContentPane().add(t1);
	        t1.setColumns(10);
	        t1.setText(user.getId()); //로그인할때 id 값을  회원수정페이지에 그대로 올수있게 해준거
	                                //dto로 받아서 꺼낸거니 줄때 받을때 메소드 입력값에 dto 넣어줘야함
	                                //클라스가 서로맞물려있거나하면 다른페이지 오갈때도 입력값이랑 메서드()맞춰줘야함


	        JLabel l2 = new JLabel("현재PW");
	        l2.setBounds(78, 137, 206, 64);
	        l2.setFont(new Font("굴림", Font.BOLD, 55));
	        f.getContentPane().add(l2);


	        t2 = new JPasswordField();
	        t2.setBounds(320, 134, 506, 70);
	        t2.setFont(new Font("굴림", Font.BOLD, 55));
	        f.getContentPane().add(t2);
	        t2.setColumns(10);


	        JLabel l3 = new JLabel("변경할PW");
	        l3.setBounds(52, 222, 264, 64);
	        l3.setFont(new Font("굴림", Font.BOLD, 55));
	        f.getContentPane().add(l3);


	        t3 = new HintTextField("PW변경시 입력.");
	        t3.setBounds(320, 219, 506, 70);
	        t3.setFont(new Font("굴림", Font.BOLD, 55));
	        f.getContentPane().add(t3);
	        t3.setColumns(10);


	        JButton b1 = new JButton("비밀번호변경");
	        b1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String data = t1.getText();
	                String data2 = t2.getText();
	                String data3 = t3.getText();
	                UserDAO dao = new UserDAO();
	                try {
	                    UserDTO dto = dao.select(data);
	                    if (data.equals(dto.getId()) && data2.equals(dto.getPw())) {
	                        dao.update(data, data3);
	                    //    JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다. 다시 로그인 해주세요.");
	                        new Login();
	                        
	                    } else {
	                        JOptionPane.showMessageDialog(null, "확인후 다시 입력해주세요.");
	                    }
	                } catch (Exception e1) {
	                }
	            }


	        });
	        b1.setBounds(118, 375, 381, 73);
	        b1.setFont(new Font("굴림", Font.BOLD, 48));
	        f.getContentPane().add(b1);


	        JButton b2 = new JButton("회원탈퇴");
	        b2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               int result = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?");
	                switch (result) {
	                case 0:
	                    String data = t1.getText();
	                    String data2 = t2.getText();
	                    UserDAO dao = new UserDAO();
	                    try {
	                        UserDTO dto = dao.select(data);
	                        if (data.equals(dto.getId()) && data2.equals(dto.getPw())) {
	                            dao.delete(data);
	                            JOptionPane.showMessageDialog(null, "탈퇴완료!");
	                            f.setVisible(false);
	                            new Login();
	                        } else {
	                            JOptionPane.showMessageDialog(null, "확인후 다시입력바랍니다.", "탈퇴실패", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } catch (Exception e1) {
	                    }
	                    break;
	                case 1:
	                    break;
	                default:


	                    break;
	                }
	            }
	        });
	        b2.setBounds(518, 375, 265, 73);
	        b2.setFont(new Font("굴림", Font.BOLD, 48));
	        f.getContentPane().add(b2);


	        f.setVisible(true);
	    }
	}

