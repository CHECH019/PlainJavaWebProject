package controladores;

import java.io.IOException;
import java.util.List;

import dao.PersonaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PersonaDTO;

@WebServlet(name="PersonaServlet", urlPatterns = "/personas")
public class PersonaControlador extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonaDAO personaDAO = new PersonaDAO(DBConnection.getConnection());
        List<PersonaDTO> personas = personaDAO.findAll();
        req.setAttribute("personas", personas);
        getServletContext().getRequestDispatcher("/JSP/personas.jsp").forward(req, resp);
        /**
         * /personas?firstName=Sergio&lastName=Suarique
         * req.getParameter("firstName"); 
         * req.getParameter("lastName");
         */
        

        // resp.sendRedirect("https://google.com");
        
    }
}