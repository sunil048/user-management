package com.repository.role;

public class RoleConstants {
	
	public static String SQL_GET_LIST_ROLENAMES = "select role.name from role";
	public static String SQL_GET_LIST_ROLENAMES_BY_USERID = "select u.username,r.name from users u ,role r where u.id=r.id AND u.id=?";
	

}
