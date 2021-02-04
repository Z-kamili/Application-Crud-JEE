package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import DAO.entities.IArticleDao;
import metier.entities.Article;
import metier.entities.ArticleDaoImplementation;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IArticleDao metier;
    /**
     * @see HttpServlet#HttpServlet()
     */
       
       @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	metier = new ArticleDaoImplementation();
    }
       
    public ControleurServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.equals("/index.java")) {
			
			request.getRequestDispatcher("/WEB-INF/Article.jsp").forward(request,response);
			
		}
		else if(path.equals("/chercher.java")){
			String motCle = request.getParameter("motCle");
			ArticleModel model = new  ArticleModel();
			model.setMotCle(motCle);
			List<Article> article = metier.ArticleParMC("%" +motCle+ "%");
			model.setArticle(article);
			request.setAttribute("model",model);
			request.getRequestDispatcher("/WEB-INF/Article.jsp").forward(request,response);
		}else if(path.contentEquals("/Saisie.java")){
			
			request.getRequestDispatcher("/WEB-INF/Saisie.jsp").forward(request,response);
			
		}else if(path.equals("/SaveArticle.java")&&(request.getMethod().equals("POST"))){
			String title = request.getParameter("title");
			float price =Float.parseFloat(request.getParameter("Price"));
			Article p = metier.save(new Article(title,price));
			request.setAttribute("article",p);
			request.getRequestDispatcher("/WEB-INF/Confirmation.jsp").forward(request,response);
		}else if(path.equals("/Supprimer.java")){
			int id =  Integer.parseInt(request.getParameter("id"));
			metier.deleteArticle(id);
			response.sendRedirect("chercher.java?motCle=");
		}else if(path.equals("/Edit.java")){			
			int id =  Integer.parseInt(request.getParameter("id"));
			Article p = metier.getArticle(id);
			request.setAttribute("article",p);
			request.getRequestDispatcher("/WEB-INF/EditArticle.jsp").forward(request,response);
		}else if(path.equals("/UpdateArticle.java")&&(request.getMethod().equals("POST"))){
			String title = request.getParameter("title");
			int id = Integer.parseInt(request.getParameter("id"));
			float price =Float.parseFloat(request.getParameter("Price"));
			Article p = new Article(title,price);
			p.setId(id);
			metier.update(p);
			request.setAttribute("article",p);
			request.getRequestDispatcher("/WEB-INF/Confirmation.jsp").forward(request,response);
		}else{
			
			response.sendError(Response.SC_NOT_FOUND);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		doGet(request,response);
		
	}

}
