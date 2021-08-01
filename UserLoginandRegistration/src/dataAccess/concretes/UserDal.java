package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.IUserDal;
import entities.concretes.User;

public class UserDal implements IUserDal{
	
	List<User> users = new ArrayList<User>();

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public void delete(User user) {
		users.remove(user);
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public boolean getEmail(String mail) {
		for(User user : users) {
			if (user.getEmail() == mail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for (User user : users) {
			if (user.getPassword() == password) {
				return true;
			}
		}
		return false;
	}

}
