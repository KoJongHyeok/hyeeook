package com.fastcampus.ch3;

import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.jdbc.datasource.*;

import javax.sql.*;
import java.sql.*;

public class DBConnection {
	
	// DataSource 객체 생성하는 방법(3) : @Autowired 애너테이션으로 자동 주입.
//	@Autowired ApplicationContext ac;
	@Autowired DataSource ds;
	
	public static void main(String[] args) throws Exception {
		// *** SPRING JDBC API를 이용하여 DB에 접근하기.
		
		//----------------------------------------------------------------------------------------------------------------------
		// DataSource 객체 생성하는 방법(1) : 직접 생성.
//		String DB_URL =					//-------------------------------- DB에 접속하기 위한 URL
//				"jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf-8";
//		String DB_USER = "root";		//-------------------------------- DB ID
//		String DB_PASSWORD = "mysql";	//-------------------------------- DB PWD
//		String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//		
//		// DriverManagerDataSource : SPRING JDBC가 제공.
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		
//		ds.setDriverClassName(DB_DRIVER);
//		ds.setUrl(DB_URL);
//		ds.setUsername(DB_USER);
//		ds.setPassword(DB_PASSWORD);
		
		//----------------------------------------------------------------------------------------------------------------------		
		// DataSource 객체 생성하는 방법(2) : Bean으로 저장해서 생성.
//		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//		DataSource ds = ac.getBean(DataSource.class);
		
		//----------------------------------------------------------------------------------------------------------------------
		
		Connection conn = ds.getConnection();		// DB에 대한 연결 얻기.
		
		System.out.println("conn = " + conn);
		
	}
	
}
