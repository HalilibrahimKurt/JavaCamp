package business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.IUserCheckService;
import entities.concretes.User;

public class UserCheckManager implements IUserCheckService {

	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("�sim alan�n� doldurunuz");
			return false;
		} else {
			if (user.getFirstName().length() < 3) {
				System.out.println("�sim en az 3 karakter olmal�d�r");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("Soyisim alan�n� doldurunuz");
			return false;
		} else {
			if (user.getFirstName().length() < 3) {
				System.out.println("Soyisim en az 3 karakter olmal�d�r");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkEmail(User user) {
		String regex =  "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());

		if (user.getEmail().isEmpty()) {
			System.out.println("L�tfen E-Mail adresinizi giriniz");
			return false;
		} else {
			if (matcher.find() == false) {
				System.out.println("L�tfen E-mail adresinizi example@example.com �eklinde giriniz");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Parolan�z en az 6 karakter olmal�d�r");
			return false;
		} else if (user.getPassword().isEmpty()) {
			System.out.println("Parola alan� bo� b�rak�lamaz");
			return false;
		}

		return true;

	}

	@Override
	public boolean uniqueEmail(User user) {
		boolean isValidEmail = true;
		List<String> emailList = new ArrayList<String>();
		if (emailList.contains(user.getEmail())) {
			System.out.println("Mail adresi daha �nce kay�t olmu�. L�tfen yeni bir E-Mail giriniz.");
			isValidEmail = false;
		}
		else {
			emailList.add(user.getEmail());
			isValidEmail = true;
			
		}
		return isValidEmail;
	}

	@Override
	public boolean isValidUser(User user) {
		if (checkFirstName(user) &&
		    checkLastName(user) &&
		    checkEmail(user) &&
		    checkPassword(user)) {
			return true;
			
		}
		return false;
	}

}
