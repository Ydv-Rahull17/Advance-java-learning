package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Post;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/SocialServlet")
public class SocialServlet extends HttpServlet {

    private static List<Post> postList = new ArrayList<>();
    private static int count = 1;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            postList.removeIf(p -> p.getId() == id);
        }

        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            for (Post p : postList) {
                if (p.getId() == id) {
                    req.setAttribute("post", p);
                    RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
                    rd.forward(req, resp);
                    return;
                }
            }
        }

        req.setAttribute("posts", postList);
        RequestDispatcher rd = req.getRequestDispatcher("Social.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("add".equals(action)) {
            String content = req.getParameter("content");
            String time = LocalDateTime.now().toString();
            postList.add(new Post(count++, content, time));
        }

        if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String content = req.getParameter("content");

            for (Post p : postList) {
                if (p.getId() == id) {
                    p.setContent(content);
                }
            }
        }

        resp.sendRedirect("SocialServlet");
    }
}
