package abc;
import java.util.ArrayList;

public class Blog {
	private User user;
	private ArrayList<Post> allPosts;
	public Blog(User user) {
		allPosts = new ArrayList<Post> ();
		this.user = user;
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
}
