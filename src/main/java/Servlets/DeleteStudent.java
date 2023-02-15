package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Student;

@WebServlet("/schooldeletestudent")
public class DeleteStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id=req.getParameter("id");
		
		int id=Integer.parseInt(Id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=em.find(Student.class, id);
		if(s!=null)
		{
			et.begin();
			em.remove(s);
			et.commit();
			
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.write("Student details deleted successfully.");
			RequestDispatcher rd=req.getRequestDispatcher("AddStudentDetailsSuccessfully.html");
			rd.include(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.write("Invalid Id.");
			RequestDispatcher rd=req.getRequestDispatcher("DeleteStudent.html");
			rd.include(req, resp);
		}
	}
}
