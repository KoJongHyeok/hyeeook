
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	
	public static void main(String[] args) throws Exception {
		// *** JDBC API를 이용하여 DB에 접근하기.
		
		String DB_URL =					//-------------------------------- DB에 접속하기 위한 URL
				"jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf-8";
		String DB_USER = "root";		//-------------------------------- DB ID
		String DB_PASSWORD = "mysql";	//-------------------------------- DB PWD
		
		// DriverManager : JDBC가 제공.
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);	// DB에 대한 연결 얻기.
		Statement stmt = conn.createStatement();	// 연결된 DB에 SQL 명령문을 사용하기 위한 Statement 생성.
		
		String query = "SELECT now()";				// SQL 명령문
		ResultSet rs = stmt.executeQuery(query);	// SQL 명령문을 실행한 결과를 ResultSet에 저장.
		
		while(rs.next()) {
			String curDate = rs.getString(1);
			System.out.println(curDate);
		}
		
	}
	
}
