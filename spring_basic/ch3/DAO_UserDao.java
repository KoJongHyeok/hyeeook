package com.fastcampus.ch3;

import org.springframework.stereotype.Component;

//@Component
public interface UserDao {
	
	public User selectUser(String id);
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(String id);
	
	public void close(AutoCloseable... acs);
	
	public void deleteAll();

}
