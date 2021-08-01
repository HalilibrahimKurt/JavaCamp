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
			System.out.println("Ýsim alanýný doldurunuz");
			return false;
		} else {
			if (user.getFirstName().length() < 3) {
				System.out.println("Ýsim en az 3 karakter olmalýdýr");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("Soyisim alanýný doldurunuz");
			return false;
		} else {
			if (user.getFirstName().length() < 3) {
				System.out.println("Soyisim en az 3 karakter olmalýdýr");
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
			System.out.println("Lütfen E-Mail adresinizi giriniz");
			return false;
		} else {
			if (matcher.find() == false) {
				System.out.println("Lütfen E-mail adresinizi example@example.com þeklinde giriniz");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Parolanýz en az 6 karakter olmalýdýr");
			return false;
		} else if (user.getPassword().isEmpty()) {
			System.out.println("Parola alaný boþ býrakýlamaz");
			return false;
		}

		return true;

	}

	@Override
	public boolean uniqueEmail(User user) {
		boolean isValidEmail = true;
		List<String> emailList = new ArrayList<String>();
		if (emailList.contains(user.getEmail())) {
			System.out.println("Mail adresi daha önce kayýt olmuþ. Lütfen yeni bir E-Mail giriniz.");
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
