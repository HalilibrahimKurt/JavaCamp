package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.IRegistrationService;

public class MailVerificationManager implements IRegistrationService{
	
	List<String> verificatedEmails = new ArrayList<String>();

	@Override
	public void sendEmail(String email) {
		verificatedEmails.add(email);
	}

	@Override
	public void verificationEmail(String email) {
		System.out.println(email + " doðrulama mail'i gönderildi.");
	}

	@Override
	public boolean isVerificated(String email) {
		if (verificatedEmails.contains(email)) {
			return true;
		}
		return false;
	}

}
