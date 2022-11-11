package controladores;

import java.io.IOException;
import java.util.List;

import dao.CuentaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CuentaDTO;

@WebServlet(name="CuentaServlet", urlPatterns = "/cuentas")
public class CuentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CuentaDAO cuentaDAO = new CuentaDAO(DBConnection.getConnection());
        List<CuentaDTO> cuentas = cuentaDAO.findAll();
        req.setAttribute("cuentas", cuentas);
        getServletContext().getRequestDispatcher("/JSP/cuentas.jsp").forward(req, resp);
    }
}
