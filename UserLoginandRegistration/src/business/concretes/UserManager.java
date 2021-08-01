package business.concretes;

import business.abstracts.IRegistrationService;
import business.abstracts.IUserCheckService;
import business.abstracts.IUserService;
import dataAccess.abstracts.IUserDal;
import entities.concretes.User;

public class UserManager implements IUserService{
	
	private IUserCheckService userCheckService;
	private IRegistrationService registrationService;
	private IUserDal userDal;

	public UserManager(IUserCheckService userCheckService, IRegistrationService registrationService, IUserDal userDal) {
		this.userCheckService = userCheckService;
		this.registrationService = registrationService;
		this.userDal = userDal;
	}

	@Override
	public void singIn(User user) {
		if (userCheckService.isValidUser(user) == true) {
			System.out.println(user.getFirstName() + " kayýt iþlemi baþarýlý.");
			registrationService.sendEmail(user.getEmail());
			userDal.add(user);
		}
	}

	@Override
	public void singUp(User user) {
		registrationService.isVerificated(user.getEmail());
		
		if (registrationService.isVerificated(user.getEmail()) == true && 
			userDal.getEmail(user.getEmail()) &&
			userDal.getPassword(user.getPassword())) {
			System.out.println("Giriþ yapýldý.");
		}
		else if (registrationService.isVerificated(user.getEmail()) == false) {
			System.out.println(user.getEmail() + " E-mail doðrulamasýný yapýnýz.");
		}
		else {
			System.out.println("Kullanýcý bilgileriniz yanlýþ kontrol ediniz.");
		}
	}

}
