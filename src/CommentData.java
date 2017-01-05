public class CommentData {
	private String name;
	private String comment;
	
	public CommentData() {
		name = null;
		comment = null;
	}
	public CommentData(String n, String c) {
		name = n;
		comment = c;
	}
	public CommentData(CommentData data) {
		name = data.name;
		comment = data.comment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
