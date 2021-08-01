package business.abstracts;

public interface IRegistrationService {
	void sendEmail(String email);
	void verificationEmail(String email);
	boolean isVerificated(String email);
}
