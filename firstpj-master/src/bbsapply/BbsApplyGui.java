package bbsapply;

import user.UserDTO;
import user.UserGUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;

import GetApplicationList.GetApplicationListGui;

import java.util.Date;
import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;
import jobofferlist.JobOfferListDTO;
import jobofferlist.JobOfferListGui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Color;
import gui.GetDateInJava;

import gui.HintTextArea;
import gui.HintTextField;

public class BbsApplyGui {
	private static JTextField comNameTf;
	private static JTextField PositionTf;
	private static JTextField userNameTf;
	private static JTextField UserTelTf;
	private static JTextField userEmailTf;
	private static JTextField userStsDateTf;
	private static String userIdString;

	public BbsApplyGui(UserDTO user, JobOfferListDTO jobOffer) {

		JFrame bbsApplyFrame = new JFrame("채용정보검색프로그램");
		bbsApplyFrame.setSize(900, 600);
		bbsApplyFrame.getContentPane().setLayout(null);

		JPanel headerPn = new JPanel();
		headerPn.setBounds(0, 0, 884, 70);
		bbsApplyFrame.getContentPane().add(headerPn);

		JLabel headerinfoLb = new JLabel(new ImageIcon("applyheader.gif"));
		headerinfoLb.setBounds(0, 0, 884, 70);
		headerPn.add(headerinfoLb);

		JPanel comPn = new JPanel();
		comPn.setBounds(64, 128, 218, 61);
		bbsApplyFrame.getContentPane().add(comPn);

		JLabel comNameLb = new JLabel("지원회사명");
		comNameLb.setFont(new Font("굴림", Font.PLAIN, 15));
		comPn.add(comNameLb);

		JTextField comNameTf = new JTextField();
		comPn.add(comNameTf);
		comNameTf.setColumns(10);
		comNameTf.setText(jobOffer.getComname());

		JLabel PositionLb = new JLabel("지원직무명");
		PositionLb.setFont(new Font("굴림", Font.PLAIN, 15));
		comPn.add(PositionLb);

		JTextField PositionTf = new JTextField();
		comPn.add(PositionTf);
		PositionTf.setColumns(10);
		PositionTf.setText(jobOffer.getPosition());

		JPanel userPn = new JPanel();
		userPn.setBounds(294, 128, 535, 61);
		bbsApplyFrame.getContentPane().add(userPn);

		JLabel userNamelb = new JLabel("이        름");
		userNamelb.setFont(new Font("굴림", Font.PLAIN, 15));
		userPn.add(userNamelb);

		JTextField userNameTf = new JTextField();
		userPn.add(userNameTf);
		userNameTf.setColumns(16);
		userNameTf.setText(user.getName());

		JLabel UserTelLb = new JLabel("연 락 처");
		UserTelLb.setFont(new Font("굴림", Font.PLAIN, 15));
		userPn.add(UserTelLb);

		JTextField UserTelTf = new JTextField();
		UserTelTf.setColumns(16);
		userPn.add(UserTelTf);
		UserTelTf.setText(user.getTel());

		JLabel userStsDateLb = new JLabel("출근가능일");
		userStsDateLb.setFont(new Font("굴림", Font.PLAIN, 15));
		userPn.add(userStsDateLb);

		JTextField userStsDateTf = new HintTextField("yyyy-MM-dd");
		userStsDateTf.setColumns(16);
		userPn.add(userStsDateTf);

		JLabel UserEmailLb = new JLabel("E - mail");
		UserEmailLb.setFont(new Font("굴림", Font.PLAIN, 15));
		userPn.add(UserEmailLb);

		JTextField userEmailTf = new JTextField();
		userPn.add(userEmailTf);
		userEmailTf.setColumns(16);
		userEmailTf.setText(user.getEmail());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 216, 692, 255);
		bbsApplyFrame.getContentPane().add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JTextArea textArea = new HintTextArea("지원동기 및 자기소개를 작성해주세요.");
		textArea.setRows(50);
		textArea.setColumns(50);
		scrollPane.setViewportView(textArea);

		JPanel buttonPn = new JPanel();
		buttonPn.setBounds(64, 481, 765, 49);
		bbsApplyFrame.getContentPane().add(buttonPn);
		buttonPn.setLayout(null);

		JButton submitbutton = new JButton("제출하기");
		submitbutton.setFont(new Font("굴림", Font.BOLD, 12));
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String content = textArea.getText();
				String datestr = userStsDateTf.getText();
				java.sql.Date sqldate;
				java.util.Date date = null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				JOptionPane.showMessageDialog(null, "          지원서 제출 완료!");
				try {
					date = format.parse(datestr);
					new GetApplicationListGui(user);
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			 	bbsApplyFrame.setVisible(false);
				sqldate = new java.sql.Date(date.getTime());

				BbsApplyDAO applicationDAO = new BbsApplyDAO();
				BbsApplyDTO dto = new BbsApplyDTO();
				java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				dto.setUserid(user.getId());
				dto.setContent(content);
				dto.setStsdate(sqldate);
				dto.setPostdate(currentDate);
				dto.setComname(jobOffer.getComname());
				dto.setEmail(user.getEmail());
				dto.setName(user.getName());
				dto.setPosition(jobOffer.getPosition());
				dto.setTel(user.getTel());

				try {
					applicationDAO.insert(dto,user,jobOffer);

				} catch (Exception e1) {

					e1.printStackTrace();

				}

			}
		});

		submitbutton.setBounds(504, 9, 249, 30);
		buttonPn.add(submitbutton);

		JButton button = new JButton("<  취소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bbsApplyFrame.setVisible(false);
				try {
					new JobOfferListGui(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(12, 9, 77, 30);
		buttonPn.add(button);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(64, 216, 73, 255);
		bbsApplyFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("지원내용");
		label.setFont(new Font("굴림", Font.PLAIN, 11));
		label.setBounds(12, 122, 48, 15);
		panel.add(label);

		bbsApplyFrame.setVisible(true);
	}
}
