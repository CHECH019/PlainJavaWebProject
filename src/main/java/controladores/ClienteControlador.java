package controladores;

import java.io.IOException;

import dao.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ClienteService;

@WebServlet(name="PersonaServlet", urlPatterns = "/clientes")
public class ClienteControlador extends HttpServlet{
    
    ClienteService service = new ClienteService(new ClienteDAO(DBConnection.getConnection()));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientes", service.getAll());
        getServletContext().getRequestDispatcher("/JSP/clientes.jsp").forward(req, resp);
        /**
         * /personas?firstName=Sergio&lastName=Suarique
         * req.getParameter("firstName"); 
         * req.getParameter("lastName");
         */
        

        // resp.sendRedirect("https://google.com");
        
    }
}