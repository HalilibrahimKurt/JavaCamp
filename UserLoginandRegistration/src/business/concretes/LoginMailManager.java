package business.concretes;

import core.abstracts.IMailService;

public class LoginMailManager implements IMailService{

	@Override
	public void sendToMail(String email) {
		System.out.println(email + " do�rulama mail g�nderildi.");
	}

	@Override
	public boolean checkUserAccount(String email) {
		System.out.println(email + " kullan�c�s� do�ruland�.");
		return true;
	}

}
