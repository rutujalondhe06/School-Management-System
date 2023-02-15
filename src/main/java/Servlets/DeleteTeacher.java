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

import Entity.Teacher;

@WebServlet("/schooldeleteteacher")
public class DeleteTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t =em.find(Teacher.class, id1);
		if(t!=null)
		{
			et.begin();
			em.remove(t);
			et.commit();
			
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.write("Teacher Details Deleted Successfully.");
			RequestDispatcher rd=req.getRequestDispatcher("AddTeacherDetailsSuccessfully.html");
			rd.include(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			pw.write("Invalid Id.");
			RequestDispatcher rd=req.getRequestDispatcher("DeleteTeacher.html");
			rd.include(req, resp);
		}
	}
}
