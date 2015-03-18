package blog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;

import abc.Post;
import abc.User;

public class Blog implements Serializable{
	private User user;
	private ArrayList<Post> allPosts;
	public Blog(User user) {
		allPosts = new ArrayList<Post> ();
		this.user = user;
	}
	public void save(String filepath){
		File file = new File(filepath);
		try {
			FileOutputStream fos= new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void load(String filepath){
		File file = new File(filepath);
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				Blog read = (Blog) ois.readObject();
				this.allPosts = read.allPosts;
				this.user =read.user;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(FileNotFoundException e){
			System.out.println("Wait! There is something wrong. I cannot find this file..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void post(Post p){
		allPosts.add(p);
		System.out.println("A new post:");
		System.out.println(p);
	}
	public void list(){
		System.out.println("Current posts:");
		for(Post p:allPosts){
			System.out.print("Post["+allPosts.indexOf(p)+"]:");
			System.out.println(p);
		}
	}
	public void delete(int index){
		if (index>=0&&index<allPosts.size())
			allPosts.remove(index);
		else
			System.out.println("Illegal deletion.");
	}
	@Override
	public String toString() {
		return "Blog [user=" + user + ", allPosts=" + allPosts + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	public void setPosts(ArrayList<Post> allposts){
		for (Post p:allposts){
			this.allPosts.add(p);
		}
	}
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		for (Post p : allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if (postMonth==month-1&&p.contains(someone)) System.out.println(p);
		}
	}
}
