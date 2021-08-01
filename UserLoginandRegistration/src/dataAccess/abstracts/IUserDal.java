package dataAccess.abstracts;


import java.util.List;

import entities.concretes.User;

public interface IUserDal {
	List<User> getAll();
	void add(User user);
	void delete(User user);
	void update(User user);
	boolean getEmail(String mail);
	boolean getPassword(String password);
	
}
