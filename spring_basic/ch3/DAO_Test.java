package com.fastcampus.ch3;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // ApplicationContext 객체를 자동으로 만들어 줌.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest {
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void test() {
		// ------------ 필요없는 코드지만 테스트를 위해 작성
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2022, 2, 2);
		//-------------
		
		User user = new User("ccc", "bbb", "bbb", "bbb@bbb.com", new Date(cal.getTimeInMillis()), "insta", new Date(cal.getTimeInMillis()));
		
		userDao.deleteAll();
		
		int rowCount = userDao.insertUser(user);
		assertTrue(rowCount==1);
		
		user.setPwd("mcmcmcm");
		user.setEmail("www.asdfsfdhejcj.com");
		
		rowCount = userDao.updateUser(user);
		assertTrue(rowCount==1);
		
		User user2 = userDao.selectUser(user.getId());
		System.out.println("user = " + user);
		System.out.println("user2 = " + user2);
		assertTrue(user.equals(user2));
	}

}
