package metier.entities;

import java.io.InputStream;

public class Article {

	private int id;
	private String title;
	private float price;
	//private InputStream image;
	
	public int getId() {
		return id;
	}

	
	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Article(int id,String title, float price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	public Article(String title, float price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	public Article(){
		super();
	}
	
	
	
}
