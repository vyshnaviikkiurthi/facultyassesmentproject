import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/CourseSelectionServlet")

public class CourseSelectionServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException {

response.setContentType("text/html");

PrintWriter out = response.getWriter();

String subjectCode = request.getParameter("subjectCode");

String subject = request.getParameter("subject");

String outcome1 = request.getParameter("outcome1");

String outcome2 = request.getParameter("outcome2");

String outcome3 = request.getParameter("outcome3");

String outcome4 = request.getParameter("outcome4");

String outcome5 = request.getParameter("outcome5");

try {

// Load the MySQL JDBC driver

Class.forName("oracle.jdbc.driver.OracleDriver");

// Create a connection to the database

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","varma");

// Prepare the SQL query

PreparedStatement pstmt = con.prepareStatement("INSERT INTO outcomes (Subjectcode, subject, outcome1, outcome2, outcome3, outcome4, outcome5) VALUES (?, ?, ?, ?, ?, ?, ?)");

pstmt.setString(1, subjectCode);

pstmt.setString(2, subject);

pstmt.setString(3, outcome1);

pstmt.setString(4, outcome2);

pstmt.setString(5, outcome3);

pstmt.setString(6, outcome4);

pstmt.setString(7, outcome5);

ResultSet rs=pstmt.executeQuery();

con.close();

} catch (Exception e) {

out.println("<h3>Error: " + e.getMessage() + "</h3>");

}

response.sendRedirect("co-po_art.html");

}

}