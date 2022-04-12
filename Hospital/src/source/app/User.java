package source.app;

public class User {

	private String name;
	private String email;
	private String ic;
	private String phnum;
	private String pass;
	

	
	public User(String name, String email, String ic, String phnum,String pass) {
		
		this.name=name;
		this.email=email;
		this.ic=ic;
		this.phnum=phnum;
		this.pass=pass;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getIC() {
		return ic;
	}
	
	public String getPhNum() {
		return phnum;
	}
	public String getPass() {
		return pass;
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setIC(String ic) {
		this.ic=ic;
	}
	
	public void setPhNum(String phnum) {
		this.phnum=phnum;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	
	
}
