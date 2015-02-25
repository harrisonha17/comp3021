package abc;

public class User {
	private int id;
	private String code;
	private String mail;
	
	public User(int id, String code, String mail){
		this.id=id;
		this.code=code;
		this.mail=mail;
	}
	
	public boolean equals(Object o){
		boolean ans = true;
		o.getClass();
		User user = (User) o;
		if (user.id!=this.id)
			ans = false;
		if (user.code!=this.code)
			ans = false;
		if (user.mail!=this.mail)
			ans = false;
		return ans;
	}
	
	public String toString(){
		return("User [userId="+id+", userName="+code+", userEmail="+mail);
	}
}
