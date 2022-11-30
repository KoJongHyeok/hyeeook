package com.fastcampus.ch3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	DataSource ds;
	
	final int FAIL = 0;
	
	//---------------------------------------------------------------------------------------------------------------------
	// 자원 반환(close) 방법 (1) : close()
	public void close(AutoCloseable... acs) {	// 가변인자 매개변수. 가변인자는 컴파일시 배열로 처리됨(0개나 1개도 마찬가지).
		for (AutoCloseable ac : acs) {			// Connection과 PreparedStatement는 AutoCloseable 인터페이스를 구현함.
			try { if(ac!=null) { ac.close(); } }
			catch (Exception e) { e.printStackTrace(); e.getMessage(); }
			// 생성 역순으로 close 해야 함.
		}	// 선언 및 생성 : Connection >> PreparedStatement >> ResultSet
		// close : ResultSet >> PreparedStatement >> Connection
	}
	
	public User selectUser(String id) {
		String sql = "select * from user_info where id=?";
		User user = new User();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setBirth(new Date(rs.getDate("birth").getTime()));
				user.setSns(rs.getString("sns"));
				user.setReg_date(new Date(rs.getDate("reg_date").getTime()));
			}
			
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			
			return null;
		} finally {
			close(rs, pstmt, conn);	// 자원 반환(close) 방법 (1) : close()
			
		}
	}

	public int insertUser(User user) {
		String sql = "insert into user_info values (?, ?, ?, ?, ?, ?, now())";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
			pstmt.setString(6, user.getSns());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			
			return FAIL;	// 예외가 발생하면 DB에서 영향받은 행이 '0'개이므로 '0'을 반환.
		} finally {
			close(pstmt, conn);	// 자원 반환(close) 방법 (1) : close()
			
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	// 자원 반환(close) 방법 (2) : try-with-resources (since jdk7)
	public int updateUser(User user) {
		String sql = "update user_info " +
					 "set pwd=?, name=?, email=?, birth=?, sns=? " +
					 "where id=?";
		
		try (	// 이 괄호 안에 있는 객체는 예외가 발생하든 안하든 자동으로 close 처리됨.
				// AutoCloseable 인터페이스를 구현한 것만 이 괄호 안에 들어올 수 있음.
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));	// 자바에서는 util.Date를 사용, DB에서는 sql.Date를 사용하므로 변환함.
			pstmt.setString(5, user.getSns());
//			pstmt.setTimestamp(6, new java.sql.Timestamp(user.getReg_date().getTime()));	// 날짜와 시간까지 표시할 수 있는 클래스.
			pstmt.setString(6, user.getId());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			
			return FAIL;	// 예외가 발생하면 DB에서 영향받은 행이 '0'개이므로 '0'을 반환.
			
		}
			
	}
	
	// 자원 반환(close) 방법 (2) : try-with-resources (since jdk7)
	public int deleteUser(String id) {
		String sql = "delete from user_info where id=?";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			
			return FAIL;	// 예외가 발생하면 DB에서 영향받은 행이 '0'개이므로 '0'을 반환.
			
		}
	}
	
	public void deleteAll() {
		String sql = "delete from user_info";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			
		} finally {
			close(pstmt, conn);
		}
	}
	
}
