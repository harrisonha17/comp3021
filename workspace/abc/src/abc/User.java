package abc;

import java.io.Serializable;

public class User implements Comparable<User>,Serializable{
	private int id;
	private String code;
	private String mail;
	
	public User(int id, String code, String mail){
		this.id=id;
		this.code=code;
		this.mail=mail;
	}
	
	@Override
	public int compareTo(User u){
		if (id>u.id) return 1;
		else if (id<u.id) return -1;
		else return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}



	public String toString(){
		return("User [userId="+id+", userName="+code+", userEmail="+mail);
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return code;
	}
}
