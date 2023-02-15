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

@WebServlet("/schooladdteacher")
public class AddTeacherDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String salary=req.getParameter("salary");
		
		int id1=Integer.parseInt(id);
		double salary1=Double.parseDouble(salary);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t=new Teacher();
		t.setId(id1);
		t.setT_name(name);
		t.setSubject(subject);
		t.setSalary(salary1);
		
		et.begin();
		em.persist(t);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("AddTeacherDetailsSuccessfully.html");
		PrintWriter pr=resp.getWriter();
		pr.write("Teacher Details added successsfully..");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}
