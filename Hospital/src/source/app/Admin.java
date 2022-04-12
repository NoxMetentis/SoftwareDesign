package source.app;

public class Admin {

	private String name;
	private String email;
	private String ic;
	private String phnum;
	private String pass;
	

	
	public Admin(String name, String email, String ic, String phnum,String pass) {
		
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
	
	
}
