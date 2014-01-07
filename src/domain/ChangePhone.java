package domain;

public class ChangePhone {

	public void changeNumber(String phoneNumber) throws Throwable{
		if(phoneNumber.startsWith("0")){
			String newPhone = "+33" + phoneNumber.substring(1);
			phoneNumber = newPhone;
			System.err.println("phonenumber: "+phoneNumber);
		}
			
	}
}
