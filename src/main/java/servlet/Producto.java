package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="HelloServlet", urlPatterns = "/hello")
public class Producto extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the POST request has been made to /hello");
        resp.setContentType("text/plain");
        resp.getWriter().println("Here is a line from POST METHOD");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the GET request has been made to /hello");
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello! this is a GET REQUEST</h1>");
        resp.getWriter().println("<p>Wlcome to my website</p>");

    }
}
