package domain;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup {
	private Integer groupId;
	private String groupName;
	private int version;
	private List<Contact> contacts;

	public ContactGroup(){
		this.contacts = new ArrayList<>();
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
