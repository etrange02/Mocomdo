package domain;

public class Address {
	
	private int id;
	private String street;
	private String city;
	private String zip;
	private String country;
	
	public Address() {
		this.id = -1;
		this.street = "";
		this.city = "";
		this.zip = "";
		this.country = "";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
