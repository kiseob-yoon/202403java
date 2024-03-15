package dto;

public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	private int likes;
	private int dislikes;
	private int memberno;
	
	

	public Board() {
		super();
	}

	public Board(int num, String writer, String title, String content, String regtime, int hits, int likes,
			int dislikes, int memberno) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.likes = likes;
		this.dislikes = dislikes;
		this.memberno = memberno;
	}
		
	public Board(int num, String writer, String title, String content, String regtime, int hits) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
	}

	public Board(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	public Board(String writer, String title, String content, int memberno) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.memberno = memberno;
	}

	public Board(int num) {
		super();
		this.num = num;
	}
	
	


	public Board(int num, String writer, String title, String content, String regtime, int hits, int likes) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.likes = likes;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", regtime="
				+ regtime + ", hits=" + hits + ", likes=" + likes + ", dislikes=" + dislikes + ", memberno=" + memberno
				+ "]";
	}
	
	
}


