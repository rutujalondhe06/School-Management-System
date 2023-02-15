<%@page import="java.io.PrintWriter"%>
<%@page import="Entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher by ID</title>
</head>
<body>
<%
	String id=request.getParameter("id");

	int id1=Integer.parseInt(id);

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("rutuja");
	EntityManager em=emf.createEntityManager();
	
	Teacher t=em.find(Teacher.class, id1);
	
	PrintWriter pw=response.getWriter();
	pw.write("Teacher Id : "+t.getId());
	pw.write("<br>Teacher Name : "+t.getT_name());
	pw.write("<br>Teacher Subject : "+t.getSubject());
	pw.write("<br>Teacher Salary : "+t.getSalary());
%>
<br>
<button type="submit"><a href="TeacherCrud.html">Done</a></button>
</body>
</html>