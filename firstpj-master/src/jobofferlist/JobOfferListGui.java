
package jobofferlist;

import java.awt.FlowLayout;
import gui.WrapLayOut;
import user.UserDTO;
import user.UserUpdate;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import GetApplicationList.GetApplicationListGui;
import bbsapply.BbsApplyGui;


public class JobOfferListGui {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;

	public JobOfferListGui(UserDTO user) throws Exception {
		JFrame jobOfferListFrame = new JFrame("채용검색프로그램");
		jobOfferListFrame.getContentPane().setFont(new Font("굴림", Font.BOLD, 10));
		jobOfferListFrame.setSize(900, 600);
		jobOfferListFrame.getContentPane().setLayout(null);

		JPanel header = new JPanel();
		header.setBounds(0, 0, 884, 70);
		jobOfferListFrame.getContentPane().add(header);

		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("offerheader.gif"));
		header.add(lblNewLabel_2);

		JPanel nev = new JPanel();
		nev.setBounds(0, 74, 156, 477);
		jobOfferListFrame.getContentPane().add(nev);
		nev.setLayout(null);

		JLabel lblNewLabel = new JLabel("상세조건검색");
		lblNewLabel.setBounds(12, 0, 132, 37);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		nev.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("지역검색");
		lblNewLabel_1.setBounds(22, 32, 122, 28);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		nev.add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("서울");
		chckbxNewCheckBox_4.setBounds(22, 55, 122, 26);
		nev.add(chckbxNewCheckBox_4);

		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("경기");
		chckbxNewCheckBox_5.setBounds(22, 81, 122, 26);
		nev.add(chckbxNewCheckBox_5);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("인천");
		chckbxNewCheckBox_1.setBounds(22, 111, 122, 26);
		nev.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("강원");
		chckbxNewCheckBox_3.setBounds(22, 141, 122, 26);
		nev.add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("경상");
		chckbxNewCheckBox_2.setBounds(22, 169, 122, 26);
		nev.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox = new JCheckBox("전라");
		chckbxNewCheckBox.setBounds(22, 199, 122, 26);
		nev.add(chckbxNewCheckBox);

		JLabel label_1 = new JLabel("직업검색");
		label_1.setBounds(22, 240, 122, 28);
		label_1.setFont(new Font("굴림", Font.BOLD, 12));
		nev.add(label_1);

		JCheckBox checkBox = new JCheckBox("영업");
		checkBox.setBounds(22, 266, 122, 26);
		nev.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("관리");
		checkBox_1.setBounds(22, 326, 122, 26);
		nev.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("무역");
		checkBox_2.setBounds(22, 296, 122, 26);
		nev.add(checkBox_2);

		JCheckBox checkBox_3 = new JCheckBox("IT/인터넷");
		checkBox_3.setBounds(22, 356, 122, 26);
		nev.add(checkBox_3);

		JCheckBox checkBox_4 = new JCheckBox("인사노무");
		checkBox_4.setBounds(22, 386, 122, 26);
		nev.add(checkBox_4);

		JCheckBox checkBox_5 = new JCheckBox("기타");
		checkBox_5.setBounds(22, 416, 122, 26);
		nev.add(checkBox_5);

		JButton btnNewButton_1 = new JButton("검색하기");
		btnNewButton_1.setBounds(32, 444, 97, 23);
		nev.add(btnNewButton_1);

		JPanel filler = new JPanel();
		filler.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		filler.setBounds(187, 115, 649, 417);
		filler.setLayout(null);

		JPanel contents = new JPanel();
		JScrollPane scrollPane = new JScrollPane(contents);
		contents.setLayout(new WrapLayOut());
		

		JobOfferListDAO dao = new JobOfferListDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<JobOfferListDTO> list = dao.selectAll();

		for (int i = 0; i < list.size(); i++) {
			JobOfferListDTO jobOffer = list.get(i);

			textField_5 = new JTextField();
			contents.add(textField_5);
			textField_5.setColumns(55);
			textField_5.setText(jobOffer.getTitle());

			JLabel lblNewLabel_6 = new JLabel("지    역");
			lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 12));
			contents.add(lblNewLabel_6);

			textField = new JTextField();
			textField.setFont(new Font("굴림", Font.PLAIN, 13));
			contents.add(textField);
			textField.setColumns(5);
			textField.setText(jobOffer.getDistrict());

			JLabel lblNewLabel_7 = new JLabel("경    력");
			lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 12));
			contents.add(lblNewLabel_7);

			textField_1 = new JTextField();
			textField_1.setFont(new Font("굴림", Font.PLAIN, 13));
			contents.add(textField_1);
			textField_1.setColumns(5);
			textField_1.setText(jobOffer.getCareer());

			JLabel lblNewLabel_8 = new JLabel("고용형태");
			lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 12));
			contents.add(lblNewLabel_8);

			textField_2 = new JTextField();
			textField_2.setFont(new Font("굴림", Font.PLAIN, 13));
			contents.add(textField_2);
			textField_2.setColumns(5);
			textField_2.setText(jobOffer.getFulltime());

			JLabel lblNewLabel_9 = new JLabel("직     무");
			lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 12));
			contents.add(lblNewLabel_9);

			textField_3 = new JTextField();
			textField_3.setFont(new Font("굴림", Font.PLAIN, 13));
			contents.add(textField_3);
			textField_3.setColumns(5);
			textField_3.setText(jobOffer.getPosition());

			JLabel lblNewLabel_10 = new JLabel("학력사항");
			lblNewLabel_10.setFont(new Font("굴림", Font.BOLD, 12));
			contents.add(lblNewLabel_10);

			textField_4 = new JTextField();
			textField_4.setFont(new Font("굴림", Font.PLAIN, 13));
			contents.add(textField_4);
			textField_4.setColumns(6);
			textField_4.setText(jobOffer.getEdu());

			JLabel lblNewLabel_5 = new JLabel("모집마감일");
			lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 11));
			contents.add(lblNewLabel_5);

			textField_6 = new JTextField();
			textField_6.setFont(new Font("굴림", Font.PLAIN, 13));
			contents.add(textField_6);
			textField_6.setColumns(9);
			textField_6.setText(sdf.format(jobOffer.getDeadlinedate()));
	
			JLabel blank = new JLabel("             ");
			blank.setFont(new Font("굴림", Font.PLAIN, 12));
			contents.add(blank);
			
			JButton btnNewButton = new JButton("즉시지원");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jobOfferListFrame.setVisible(false);	
					
					new BbsApplyGui(user,jobOffer);
				}
			});
						
						JLabel lblNewLabel_3 = new JLabel("회 사 명");
						lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
						contents.add(lblNewLabel_3);
			
						textField_7 = new JTextField();
						textField_7.setBounds(756, 122, 116, 21);
						contents.add(textField_7);
						textField_7.setColumns(10);
						textField_7.setText(jobOffer.getComname());
			btnNewButton.setBounds(640, 121, 97, 23);
			contents.add(btnNewButton);

		}
		scrollPane.setBounds(0, 5, 640, 412);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		filler.add(scrollPane);
		jobOfferListFrame.getContentPane().add(filler);
		
		JButton btnNewButton_3 = new JButton("내지원현황");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobOfferListFrame.setVisible(false);	
				try {
					new GetApplicationListGui(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNewButton_3.setBounds(621, 70, 97, 35);
		jobOfferListFrame.getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton("내정보수정");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserUpdate(user);
				jobOfferListFrame.setVisible(false);
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 12));
		button.setBounds(730, 70, 97, 35);
		jobOfferListFrame.getContentPane().add(button);
		jobOfferListFrame.setVisible(true);

	}
}
