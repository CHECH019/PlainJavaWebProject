package controladores;

import java.io.IOException;
import java.util.List;

import dao.TarjetaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TarjetaDTO;

@WebServlet(name = "TarjetaServlet", urlPatterns = "/tarjetas")
public class TarjetaControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TarjetaDAO tarjetaDAO = new TarjetaDAO(DBConnection.getConnection());
        List<TarjetaDTO> tarjetas = tarjetaDAO.findAll();
        req.setAttribute("tarjetas", tarjetas);
        getServletContext().getRequestDispatcher("/JSP/tarjetas.jsp").forward(req, resp);
    
    }
}
