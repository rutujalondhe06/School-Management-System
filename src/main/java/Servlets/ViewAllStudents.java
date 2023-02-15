package Servlets;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import Entity.Student;

@WebServlet("/viewallstudents")
public class ViewAllStudents extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select s from Student s");
		List<Student> s=q.getResultList();
		
		HttpSession hs=req.getSession();
		hs.setAttribute("viewStudents", s);
		
		RequestDispatcher rd=req.getRequestDispatcher("ViewAllStudents.jsp");
		rd.include(req, resp);
	}
}
