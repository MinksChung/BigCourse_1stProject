package GetApplicationList;

import bbsapply.BbsApplyDTO;
import jobofferlist.JobOfferListDTO;
import jobofferlist.JobOfferListGui;
import user.UserDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.org.apache.xml.internal.utils.ObjectPool;
import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.*;

public class GetApplicationListGui {
	private static JTable table;
	private static JTable table1;
	Object[][] item;
	int temp;

	public GetApplicationListGui(UserDTO user) throws Exception {
		GetApplicationListDAO dao= new GetApplicationListDAO();
		
		Object[] title = {"no", "지원회사", "지원직무","지원날짜"};
		ArrayList<BbsApplyDTO> list = dao.selectAll();
		temp=list.size();
		item=new Object[temp][4];

		for(int i=0; i<list.size(); i++) {
			 BbsApplyDTO  pickedForApplier= list.get(i);
			 item[i][0]=pickedForApplier.getDocid();
			 item[i][1]=pickedForApplier.getComname();
			 item[i][2]=pickedForApplier.getPosition();
			 item[i][3]=pickedForApplier.getPostdate();
			 
			 }
		
				
		JFrame GetApplListFrame = new JFrame("채용정보검색프로그램");
		GetApplListFrame.setSize(900, 600);
		GetApplListFrame.getContentPane().setLayout(null);
		
		table1=new JTable(item, title);
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(42, 102, 777, 383);
		GetApplListFrame.getContentPane().add(scrollPane);

		
		JLabel lblNewLabel = new JLabel(new ImageIcon("getheader.gif"));
		lblNewLabel.setBounds(0, 0, 884, 70);
		GetApplListFrame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("메인페이지");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new JobOfferListGui(user);
					GetApplListFrame.setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	

		btnNewButton.setBounds(244, 506, 117, 34);
		GetApplListFrame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("프로그램종료");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		
		btnNewButton_1.setBounds(488, 506, 117, 34);
		GetApplListFrame.getContentPane().add(btnNewButton_1);

		GetApplListFrame.setVisible(true);
	}
}
