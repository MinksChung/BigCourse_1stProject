package bbsapply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jobofferlist.JobOfferListDAO;
import jobofferlist.JobOfferListDTO;
import user.UserDTO;

public class BbsApplyDAO {
	public void insert(BbsApplyDTO dto, UserDTO user1, JobOfferListDTO jobOffer1) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/firstpj?characterEncoding=utf8";
		String user = "root";
		String password = "0923";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "insert into bbsapply values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, null);
		ps.setString(2, user1.getId());
		ps.setString(3, user1.getName());
		ps.setString(4, jobOffer1.getComname());
		ps.setString(5, jobOffer1.getPosition());
		ps.setString(6, user1.getTel());
		ps.setString(7, user1.getEmail());
		ps.setString(8, dto.getContent());
		ps.setDate(9, dto.getStsdate());
		ps.setDate(10, dto.getPostdate());

		System.out.println("3. SQL문 객체화 ok...");

		ps.executeUpdate();

		System.out.println("4. SQL문 전송 요청 성공...asdfsdf");
		ps.close();
		con.close();
	}

}
