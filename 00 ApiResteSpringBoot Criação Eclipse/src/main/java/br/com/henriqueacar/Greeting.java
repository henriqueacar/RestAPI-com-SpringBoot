package br.com.henriqueacar;

public class Greeting {
	private final long id;
	private final String content;

	public long getId() {
		return id;
	}
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	public String getContent() {
		return content;
	}

}
