package OppsCONCEPT;
//encapsulation 
class account{
	
	public String name;
	protected String email ;
	private String password;
	
	
	//getter and setter mthod
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String pass) {
		
		this.password=pass;
		
	}
	
}


public class Bank {

	public static void main(String[] args) {
	
		account account1=new account();
		
		account1.name="putali";
		account1.email="putali@gmail.com";
		 account1.setPassword("abcd");
		System.out.println("1 " +account1.name+" 2 "+account1.email+ " 3 "+account1.getPassword());
		

	}

}
