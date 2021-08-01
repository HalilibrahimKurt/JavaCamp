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
			System.out.println(user.getFirstName() + " kay�t i�lemi ba�ar�l�.");
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
			System.out.println("Giri� yap�ld�.");
		}
		else if (registrationService.isVerificated(user.getEmail()) == false) {
			System.out.println(user.getEmail() + " E-mail do�rulamas�n� yap�n�z.");
		}
		else {
			System.out.println("Kullan�c� bilgileriniz yanl�� kontrol ediniz.");
		}
	}

}
