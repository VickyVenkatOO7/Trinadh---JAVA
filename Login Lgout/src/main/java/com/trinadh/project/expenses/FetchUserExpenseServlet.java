package com.trinadh.project.expenses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FetchUserExpenseServlet")
public class FetchUserExpenseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		ServletContext sContext = getServletContext();
		String sessionUserName = sContext.getAttribute("username").toString();
		System.out.println(sContext.getAttribute("username"));
		
		pw.print("<div>\r\n"
				+ "			<form action=\"ExpenseInsertionServlet\" method=\"\" >\r\n"
				+ "				<table>\r\n"
				+ "<tr>\r\n"
				+ "						<td><input type='hidden' name='sessionUserName' value='"+ sessionUserName+"'/></td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td>Expense Date:</td>\r\n"
				+ "						<td><input type=\"date\" name=\"exp_date\"/></td>\r\n"
				+ "						\r\n"
				+ "						<td>Expense Category:</td>\r\n"
				+ "						<td>\r\n"
				+ "							<select name=\"exp_category\">\r\n"
				+ "								<option value=\"1\">Food</option>\r\n"
				+ "								<option value=\"2\">Cloths</option>\r\n"
				+ "								<option value=\"3\">House Holds</option>\r\n"
				+ "								<option value=\"4\">Medicine&Hospital</option>\r\n"
				+ "								<option value=\"5\">Travel&Fuel</option>\r\n"
				+ "							</select>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td>Expense Details:</td>\r\n"
				+ "						<td><input type=\"text\" name=\"exp_desc\"/></td>\r\n"
				+ "						\r\n"
				+ "						<td>Expense Amount:</td>\r\n"
				+ "						<td><input type=\"text\" name=\"exp_amount\"/></td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td></td>\r\n"
				+ "						\r\n"
				+ "						<td colspan=\"2\" style=\"text-align: center\"><input type=\"submit\" value=\"ADD EXPENSE\"/></td>\r\n"
				+ "						<td></td>\r\n"
				+ "					</tr>\r\n"
				+ "				</table>\r\n"
				+ "			</form>\r\n"
				+ "			\r\n"
				+ "		</div>");
		
			pw.println("<form action='LogoutServlet' >");
			pw.println("<input type='submit' value='logout'>");
			pw.println("</form>");
		
			String username=(String) req.getSession().getAttribute("username");
			
			DBConfiguration DB = new DBConfiguration();
			Connection con = DB.DBConfig();
			String sql ="select * from expenses where user_id=? ORDER BY exp_date DESC";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, username);
				ResultSet rs = pst.executeQuery();
				 
				pw.println("<html><body><table border=\"1\">");
				pw.println("<tr><th>Date</th><th>exp category</th><th>Description</th><th>Amount</th></tr>");
				while(rs.next())  {
					pw.println("<tr>");
					pw.println("<td>"+rs.getString("exp_date")+"</td>");
					pw.println("<td>"+rs.getString("exp_cat")+"</td>");
					pw.println("<td>"+rs.getString("exp_des")+"</td>");
					pw.println("<td>"+rs.getString("exp_amount")+"</td>");
				    pw.println("</tr>");
				}
				pw.println("</table></body></html>");
				
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}