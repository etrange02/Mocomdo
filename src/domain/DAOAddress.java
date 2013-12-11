package domain;

import java.util.ArrayList;
import java.util.List;


public class DAOAddress {

	public Address createAddress(String street,String city,String zip,String country){
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		return address;
	}
	
	public void modifyAddress(Address address,String street,String city,String zip,String country){
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
	}
	
	public List<Contact> searchAdrress(String street,String city,String zip,String country){
		List<Contact> liste = new ArrayList<Contact>();
		
		
		return liste;
	}
	
}
