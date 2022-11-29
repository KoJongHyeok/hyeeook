
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // ApplicationContext 객체를 자동으로 만들어 줌.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void main() throws Exception {

//		ApplicationContext ac = new GenericXmlApplicationContext(	// @RunWith(SpringJUnit4ClassRunner.class) 애너테이션이 있으므로 필요없는 코드.
//				"file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//		DataSource ds = ac.getBean(DataSource.class);		// @Autowired 애너테이션으로 자동 주입받으므로 필요없는 코드.

		Connection conn = ds.getConnection();

		System.out.println("conn = " + conn);
		assertTrue(conn!=null);
		
	}
	
//	@Test
//	public void insertUserTest() throws Exception {
//		deleteAll();	// 항상 테스트가 성공하도록 테스트 전에 DB의 모든 데이터를 삭제.
//		User user = new User("aaa", "123", "aaa", "aaa@aaa.com", new Date(), "facebook");
//		int rowCount = insertUser(user);
//		assertTrue(rowCount==1);
//	}
	
	// 사용자 정보를 DB에 저장하기 위한 메서드.
	public int insertUser(User user) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "insert into user_info values (?, ?, ?, ?, ?, ?, now())";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(6, user.getSns());
		
		return  pstmt.executeUpdate();	// 실행 결과 DB에서 영향을 받은 행의 갯수.
	}
	
//	@Test
//	public void selectUserTest() throws Exception {
//		deleteAll();
//		User user = new User("aaa", "123", "aaa", "aaa@aaa.com", new Date(), "facebook");
//		insertUser(user);
//		user = selectUser("aaa");
//		assertTrue(user.getId().equals("aaa"));
//	}
	
	public User selectUser(String id) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "select * from user_info where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.setId(rs.getString(1));
			user.setPwd(rs.getString(2));
			user.setName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setBirth(new Date(rs.getDate(5).getTime()));
			user.setSns(rs.getString(6));
			user.setReg_date(new Date(rs.getDate(7).getTime()));
			
			return user;
		}
		return null;
	}
	
	@Test
	public void updateUserTest() throws Exception {
		deleteAll();
		
		int rowCount = insertUser(new User("aaa", "123", "aaa", "aaa@aaa.com", new Date(), "facebook"));
		assertTrue(rowCount==1);
		
		User user = new User("aaa", "456", "bbb", "bbb@bbb.com", new Date(), "instagram");
		rowCount = updateUser(user);
		assertTrue(rowCount==1);
	}
	
	// 매개변수로 받은 사용자 정보로 DB 테이블을 업데이트하는 메서드.
	public int updateUser(User user) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "update user_info set pwd=?, name=?, email=?, birth=?, sns=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getPwd());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(5, user.getSns());
		pstmt.setString(6, user.getId());
		
		return pstmt.executeUpdate();
	}
	
//	@Test
//	public void deleteUserTest() throws Exception {
//		deleteAll();
//		User user = new User("aaa", "123", "aaa", "aaa@aaa.com", new Date(), "facebook");
//		insertUser(user);
//		int rowCount = deleteUser(user.getId());
//		assertTrue(rowCount==1);
//	}
	
	public int deleteUser(String id) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "delete from user_info where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}

	public void deleteAll() throws Exception {
		Connection conn = ds.getConnection();
		String sql = "delete from user_info";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
}
