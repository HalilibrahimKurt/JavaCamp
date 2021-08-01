package business.abstracts;

import entities.concretes.User;

public interface IUserService {
	void singIn(User user);
	void singUp(User user);
}
