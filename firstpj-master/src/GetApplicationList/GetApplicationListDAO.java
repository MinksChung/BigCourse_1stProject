package GetApplicationList;
import java.awt.peer.ListPeer;
import java.sql.*; 
import java.util.ArrayList;

import bbsapply.BbsApplyDTO;

public class GetApplicationListDAO {

		public ArrayList<BbsApplyDTO> selectAll() throws Exception {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 드라이버 설정 OK...");
		
			String url = "jdbc:mysql://localhost:3306/firstpj?characterEncoding=utf8";
			String user = "root"; 
			String password = "0923"; 
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB연결 OK...");

//			
//			String sql = "select docid, comname, position, postdate from bbsapply";
//			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. sql문 객체화 ok...");
			ArrayList<BbsApplyDTO> list = new ArrayList<BbsApplyDTO>(); 
			Statement st =con.createStatement();
	
			ResultSet rs = st.executeQuery("select * from bbsapply");
			
			while(rs.next()) {
				BbsApplyDTO dto = new BbsApplyDTO();
				int docid = rs.getInt(1);
				String userid = rs.getString(2);
				String username = rs.getString(3);
				String comname = rs.getString(4);
				String position = rs.getString(5);
				String tel = rs.getString(6);
				String email = rs.getString(7);
				String content = rs.getString(8);
				Date stsDate= rs.getDate(9);
				Date postDate = rs.getDate(10);
				
				dto.setDocid(docid);
				dto.setUserid(userid);
				dto.setName(username);
				dto.setComname(comname);
				dto.setPosition(position);
				dto.setTel(tel);;
				dto.setEmail(email);
				dto.setContent(content);;
				dto.setStsdate(stsDate);
				dto.setPostdate(postDate);
				
				System.out.println("4. sql문 실행요청 ok...");
				list.add(dto);
			
			}
			System.out.println("4. sql문 실행요청 ok...");
			//return id, pw, name, tel  <-자바에선불가능
			con.close();
			return list;
			
		}

	
}
