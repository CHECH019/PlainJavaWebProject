package controladores;

import java.io.IOException;

import Iterator.PersonaCollection;
import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="PersonaServlet", urlPatterns = "/personas")
public class PersonaControlador extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonaDAO personaDAO = new PersonaDAO(DBConnection.getConnection());
        PersonaCollection listaPersonas = new PersonaCollection(personaDAO.findAll());
        req.setAttribute("personas", listaPersonas.iterator());
        getServletContext().getRequestDispatcher("/JSP/personas.jsp").forward(req, resp);
        /**
         * /personas?firstName=Sergio&lastName=Suarique
         * req.getParameter("firstName"); 
         * req.getParameter("lastName");
         */
        

        // resp.sendRedirect("https://google.com");
        
    }
}