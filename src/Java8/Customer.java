package Java8;

import java.util.List;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private List<String> phoneNo;
	
	public Customer(int id,String name,String email, List<String> phoneNo) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phoneNo=phoneNo;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(List<String> phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
	

}
