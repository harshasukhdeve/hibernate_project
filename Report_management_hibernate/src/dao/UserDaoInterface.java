package dao;

import model.User;

public interface UserDaoInterface {
	
	int signup(User user);
	boolean loginuser(User user);

}