package jobofferlist;

import java.sql.*;
import java.util.ArrayList;

public class JobOfferListDAO {
	public ArrayList<JobOfferListDTO> selectAll() throws Exception {
		ArrayList<JobOfferListDTO> list = new ArrayList<JobOfferListDTO>();
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버 설정 ok...");

		String url = "jdbc:mysql://localhost:3306/firstpj?characterEncoding=utf8";
		String user = "root";
		String password = "0923";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 ok...");

		String sql = "select * from jobofferlist";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 ok...");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 요청 ok...");
		int totalRow = 0;

		while (rs.next()) {

			String offerid = rs.getString(1);
			String comname = rs.getString(2);
			String position = rs.getString(3);
			String title = rs.getString(4);
			String edu = rs.getString(5);
			String career = rs.getString(6);
			String fulltime = rs.getString(7);
			String district = rs.getString(8);
			Date postdate = rs.getDate(9);
			Date deadlinedate = rs.getDate(10);
			String content = rs.getString(11);
			JobOfferListDTO dto = new JobOfferListDTO();

			dto.setOfferid(offerid);
			dto.setComname(comname);
			dto.setPosition(position);
			dto.setTitle(title);
			dto.setEdu(edu);
			dto.setCareer(career);
			dto.setFulltime(fulltime);
			dto.setDistrict(district);
			dto.setPostdate(postdate);
			dto.setDeadlinedate(deadlinedate);
			dto.setContent(content);

			list.add(dto);
		}
		con.close();
		return list;
		
	}

}
