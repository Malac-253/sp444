package models;
import java.util.Date;  


public class Comment {
	
	public String commentString = "";
	public String username = "";
	public Date date;
	public boolean active = true;
	
	public Comment()
	{
		this.date = java.util.Calendar.getInstance().getTime();
		commentString = "default";
		username = "default";
		active = true;
	}

	public Comment(Person p, String c)
	{
		this.date = java.util.Calendar.getInstance().getTime();
		commentString = c;
		username = p.getUsername();
		active = true;	
	}

	//resolved comment
	public void resolvedComment()
	{
		active = false;
	}
	
	
	public String getCommentString() {
		return commentString;
	}

	public void setCommentString(String commentString) {
		this.commentString = commentString;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
