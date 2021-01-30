package com.app.course.online.user;

public interface UserService
{
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
