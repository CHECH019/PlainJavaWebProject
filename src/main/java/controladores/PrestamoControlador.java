package controladores;

import java.io.IOException;
import java.util.List;

import dao.PrestamoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PrestamoDTO;

@WebServlet(name = "PrestamoServlet", urlPatterns = "/prestamos")
public class PrestamoControlador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrestamoDAO prestamoDAO = new PrestamoDAO(DBConnection.getConnection());
        List<PrestamoDTO> prestamos = prestamoDAO.findAll();
        req.setAttribute("prestamos", prestamos);
        getServletContext().getRequestDispatcher("/JSP/prestamos.jsp").forward(req, resp);
    }
    
}
