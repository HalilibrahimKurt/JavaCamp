package core.abstracts;

public interface IMailService {
	void sendToMail(String email);
	boolean checkUserAccount(String email);
}
