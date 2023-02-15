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

@WebServlet("/schoolupdatestudent")
public class UpdateStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id=req.getParameter("id");
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String Fees=req.getParameter("fees");
		
		int id=Integer.parseInt(Id);
		double fees=Double.parseDouble(Fees);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setId(id);
		s.setS_name(name);
		s.setStream(stream);
		s.setFees(fees);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.write("Student data updated successfully.");
		
		RequestDispatcher rd=req.getRequestDispatcher("AddStudentDetailsSuccessfully.html");
		rd.include(req, resp);
	}
}
