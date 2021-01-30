package com.app.course.online.user;

public class AuthorizationImitation
{
	public static User user;
	
	public static void setUser(User user)
	{
		AuthorizationImitation.user = user;
	}
	
	public static User getUser()
	{
		return AuthorizationImitation.user;
	}
}
