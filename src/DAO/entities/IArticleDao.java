package DAO.entities;

import java.util.List;

import metier.entities.Article;

public interface IArticleDao {
	
	public Article save(Article a);
	public List<Article> ArticleParMC(String mc);
	public Article update(Article a);
	public void deleteArticle(int id);
	public Article getArticle(int id);

}
