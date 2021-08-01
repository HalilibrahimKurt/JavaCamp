package business.concretes;

import core.abstracts.IMailService;

public class LoginMailManager implements IMailService{

	@Override
	public void sendToMail(String email) {
		System.out.println(email + " doðrulama mail gönderildi.");
	}

	@Override
	public boolean checkUserAccount(String email) {
		System.out.println(email + " kullanýcýsý doðrulandý.");
		return true;
	}

}
