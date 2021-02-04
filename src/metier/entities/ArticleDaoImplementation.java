package metier.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.entities.IArticleDao;

public class ArticleDaoImplementation implements IArticleDao{
	Article a;
	@Override
	public List<Article> ArticleParMC(String mc) {
		Connection connection = DAO.entities.Connection.getConnection();
		List<Article> article = new ArrayList<Article>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("Select * from article where title LIKE ?");
			ps.setString(1, "%"+ mc + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Article a = new Article();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setPrice(rs.getFloat("Price"));
				article.add(a);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}

		return article;
	}
	@Override
	public void deleteArticle(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DAO.entities.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Article WHERE id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
	}
	@Override
	public Article getArticle(int id) {
		
		Connection connection = DAO.entities.Connection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement("Select * from article where id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			    a = new Article();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setPrice(rs.getFloat("Price"));
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}

		return a;
	}
	@Override
	public Article save(Article a) {
		try {
			Connection connection = DAO.entities.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO article (title,price) Values(?,?)");
			ps.setString(1,a.getTitle());
			ps.setFloat(2,a.getPrice());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("Select Max(ID) as MAXID from article");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				a.setId(rs.getInt("MAXID"));
			}
			ps.close();
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
	
		
		return a;
	}
	@Override
	public Article update(Article a) {
		try {
			Connection connection = DAO.entities.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE Article SET title = ? , Price = ? where id = ? ");
			ps.setString(1,a.getTitle());
			ps.setFloat(2,a.getPrice());
			ps.setFloat(3,a.getId());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("Select Max(ID) as MAXID from article");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				a.setId(rs.getInt("MAXID"));
			}
			ps.close();
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
		return a;
	}

}
