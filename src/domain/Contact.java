package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

public class Contact {
	private String firstname;
	private String lastname;
	private String email;
	private Integer id;
	private int version;
	private List<ContactGroup> books;
	private List<PhoneNumber> phones;
	private Address address;

	public Contact(){
		this.firstname="";
		this.lastname="";
		this.email="";
		this.id=-1;
		this.address = null;
		this.books = new ArrayList<ContactGroup>();
		this.phones = new ArrayList<PhoneNumber>();
	}

	public List<ContactGroup> getBooks() {
		return books;
	}

	public void setBooks(List<ContactGroup> books) {
		if (books != null)
			this.books = books;
	}
	
	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		if (phones != null)
			this.phones = phones;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if (address != null)
			this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void toupper(String lastname) {
		this.lastname = lastname.toUpperCase();
	}
	
}
