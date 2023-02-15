package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Principal;

@WebServlet("/systemlogin")
public class SchoolLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from Principal a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<Principal> principal = q.getResultList();
		if(principal.size()>0)
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Login Successfully..");
			RequestDispatcher rd=req.getRequestDispatcher("Teacher&Student.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Invalid Credentials..");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
