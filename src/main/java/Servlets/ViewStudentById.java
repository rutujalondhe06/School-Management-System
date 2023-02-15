package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

import Entity.Student;

@WebServlet("/viewstudentbyid")
public class ViewStudentById extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id=req.getParameter("id");
		
		int id=Integer.parseInt(Id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		
		Student s=em.find(Student.class, id);
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.write("Student Id : "+s.getId());
		pw.write("<br>Student Name : "+s.getS_name());
		pw.write("<br>Student Stream : "+s.getStream());
		pw.write("<br>Student Fees : "+s.getFees());
		
		RequestDispatcher rd=req.getRequestDispatcher("AddStudentDetailsSuccessfully.html");
		rd.include(req, resp);
	}
}
