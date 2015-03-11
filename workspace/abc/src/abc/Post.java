package abc;

import java.util.Date;

public class Post implements Comparable<Post>{
	private Date date;
	private String content;

	public Post(Date date, String content){
		this.date=date;
		this.content=content;
	}
	
	public int compareTo(Post p){
		return date.compareTo(p.date);
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public Date getDate(){
		return date;
	}
	
	public String toString(){
		return (this.date.toString()+"\n"+content);
	}
	
	public boolean equals(Object o){
		boolean ans = true;
		o.getClass();
		Post post = (Post) o;
		if (post.content!=this.content)
			ans = false;
		if (post.date!=this.date)
			ans = false;
		return ans;
	}
	
	public int hashCode(){
		int hashCode = 0;
		hashCode += 17*date.hashCode();
		hashCode += content.hashCode();
		return hashCode;
	}
	
	public boolean contains(String keyword){
		return content.contains(keyword);
	}
	

	
}


