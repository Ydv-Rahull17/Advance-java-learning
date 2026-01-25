package Controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Set;

/**

 * Servlet implementation class ActivateUserServlet

 */

@WebServlet("/Activateuserservlet")

public class Activateuserservlet extends HttpServlet {

 private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public Activateuserservlet() {

        super();

        // TODO Auto-generated constructor stub

    }

 /**

 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

 */

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 // TODO Auto-generated method stub

 response.setContentType("text/html");

 PrintWriter pw=response.getWriter();

 Set<String> users=(Set<String>) getServletContext().getAttribute("loggedUser");

 if(users == null || users.isEmpty()) {

             pw.print("No active users");

         } else {

             for(String u : users) {

                 pw.print("<li>" + u + "</li>");

             }

         }

 }

 }