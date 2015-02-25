package abc;
import java.util.Date;
public class FriendsPost extends Post {
	private User friend;
	
	public FriendsPost(Date date,String content, User user){
		super(date, content);
		friend=user;
	}
	public String toString(){
		return(friend.toString()+"\n"+super.toString());
	}
}
