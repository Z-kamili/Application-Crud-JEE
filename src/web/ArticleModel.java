package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Article;

public class ArticleModel {
	
	private String motCle;
	private List<Article> article = new ArrayList<Article>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Article> getArticle() {
		return article;
	}
	public void setArticle(List<Article> article) {
		this.article = article;
	}
	

}
