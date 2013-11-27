package domain;

public class Dao {

	public void createContact(int id, String firstname, String lastname, String email) {
		System.out.println("Dans createContact -> id = "+id);
		System.out.println("Dans createContact -> firstname = "+firstname);
		System.out.println("Dans createContact -> lastname = "+lastname);
		System.out.println("Dans createContact -> email = "+email);
	}

}
