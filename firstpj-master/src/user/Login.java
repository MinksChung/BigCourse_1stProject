package user;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import jobofferlist.JobOfferListGui;


public class Login implements ItemListener {
    private JTextField t1;
    private JTextField t2;


    JRadioButton rdbtnCorper, rdbtnPersenal;


    int check; // 인트 인덱스값은  0 = > 개인회원


    public Login() {
        JFrame startPageFrame = new JFrame("채용정보검색프로그램");
        startPageFrame.setSize(900, 600);
        startPageFrame.getContentPane().setLayout(null);


        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(0, 153, 255));
        panel_3.setBounds(472, 268, 255, 206);
        startPageFrame.getContentPane().add(panel_3);
        panel_3.setLayout(null);


        rdbtnPersenal = new JRadioButton("개인로그인");
        rdbtnPersenal.setBounds(13, 5, 105, 35);
        rdbtnPersenal.setFont(new Font("굴림", Font.PLAIN, 14));
        panel_3.add(rdbtnPersenal);


        rdbtnCorper = new JRadioButton("기업로그인");
        rdbtnCorper.setBounds(127, 6, 105, 35);
        rdbtnCorper.setFont(new Font("굴림", Font.PLAIN, 14));
        panel_3.add(rdbtnCorper);


        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnPersenal);
        bg.add(rdbtnCorper); // 버튼을 그룹에 추가해줘야 버튼들중에 1개만 선택할수있다 (다중선택ㄴㄴ하게)


        // radio버튼선택해줬을때 이벤트효과넣는법
        rdbtnCorper.addItemListener(this);
        rdbtnPersenal.addItemListener(this);
//        rdbtnCorper.addItemListener(new ItemListener() {            
//            public void itemStateChanged(ItemEvent e) {     //이렇게 두개만들어서 했는데 안되서 밑에 if
//                
//            }
//        });
//        rdbtnPersenal.addItemListener(new ItemListener() {            
//            public void itemStateChanged(ItemEvent e) {
//                
//            }
//        });
        


        JLabel putIdTextLb = new JLabel("회 원 I D");
        putIdTextLb.setBounds(30, 72, 79, 27);
        putIdTextLb.setFont(new Font("굴림", Font.PLAIN, 18));
        panel_3.add(putIdTextLb);


        t1 = new JTextField();
        t1.setBounds(115, 70, 127, 31);
        t1.setFont(new Font("굴림", Font.PLAIN, 18));
        panel_3.add(t1); 
        t1.setColumns(10);


        JLabel label = new JLabel("비밀번호 ");
        label.setFont(new Font("Dialog", Font.PLAIN, 18));
        label.setBounds(30, 111, 82, 27);
        panel_3.add(label);


        t2 = new JPasswordField();
        t2.setFont(new Font("Dialog", Font.PLAIN, 18));
        t2.setColumns(10);
        t2.setBounds(115, 111, 127, 31); 
        panel_3.add(t2);


        JButton signInBt = new JButton("SignUp");
        signInBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserGUI name = new UserGUI();
                startPageFrame.setVisible(false);
            }
        });
        signInBt.setBounds(13, 168, 105, 28);
        panel_3.add(signInBt);

 
        JButton button = new JButton("SignIn");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = t1.getText();
                String data2 = t2.getText();
                UserDAO dao = new UserDAO();
                try {
                    UserDTO dto = dao.select(data);
                    System.out.println(data + "---");
                    System.out.println(data2 + "---");
                    System.out.println(dto.getId() + "---");
                    System.out.println(dto.getPw() + "---");
                    if (data.equals(dto.getId()) && data2.equals(dto.getPw())) {
                        if (check == 0) { //개인회원
                            new JobOfferListGui(dto);
                            startPageFrame.setVisible(false);
                        } else { //기업회원
                                JOptionPane.showMessageDialog(null, "기업회원으로는 로그인이 불가능합니다.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "로그인정보가 옳바르지 않습니다.", "로그인실패", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e1) {
                }
            }
        });
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


    public static void main(String[] args) {
        Login name = new Login();
    }


    @Override
    public void itemStateChanged(ItemEvent e) {


        if (e.getStateChange() == ItemEvent.DESELECTED) { //버튼클릭하면 다른걸클릭해도 그전에걸 기억하고있어서 없애준거
            return;
        }
        if (rdbtnCorper.isSelected()) {  //기업용 클릭했을때는 지원불가!  그리고 check값을 1로잡아준거
            JOptionPane.showMessageDialog(null, "현재버전에서는 지원하지않습니다.", "지원불가", JOptionPane.INFORMATION_MESSAGE);
            check = 1;
        } else {
            JOptionPane.showMessageDialog(null, "개인회원으로 진행.", "개인로그인", JOptionPane.INFORMATION_MESSAGE);
            check = 0;
        }    
    }


}