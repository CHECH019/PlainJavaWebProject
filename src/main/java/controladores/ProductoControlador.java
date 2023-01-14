package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ClienteDTO;
import services.ClienteService;
import services.ProductoService;

@WebServlet(name="ProductoServlet", urlPatterns = "/productos/*")
public class ProductoControlador extends HttpServlet {
    private ProductoService productoService;
    private ClienteService clienteService;
    
    @Override
    public void init() throws ServletException {
        productoService = new ProductoService(new ProductoDAO(getServletContext()));
        clienteService = new ClienteService(new ClienteDAO(getServletContext()));    
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI();
        if(action.contentEquals("/banco/productos/buscar")){
            buscar(req, resp);
        }else if(action.contentEquals("/banco/productos/nuevo")){
            nuevoProducto(req, resp);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI();
        
        if(action.contentEquals("/banco/productos/save")){
            saveClienteProducto(req, resp);
        }
    }

    public void buscar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClienteDTO> clientes;
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        if(id != null && !id.isEmpty()){
            clientes = new ArrayList<ClienteDTO>();
            clientes.add(clienteService.getById(Long.parseLong(id)));
        }else {
            clientes = clienteService.getClientByNameAndLastName(name, lastName);
        }

        req.setAttribute("cliente", clientes.get(0));
        req.setAttribute("productos", productoService.getByClientId(clientes.get(0).getId()));
        getServletContext().getRequestDispatcher("/JSP/productos.jsp").forward(req, resp);
    }
    public void saveClienteProducto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long client_id = Long.parseLong(req.getParameter("client_id"));
        Integer product_id = Integer.parseInt(req.getParameter("product_id"));
        productoService.saveClienteProducto(client_id, product_id);
        resp.sendRedirect("/banco/productos/buscar?id="+client_id);
    }
    public void nuevoProducto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("productos", productoService.getAll());
        req.setAttribute("cliente", clienteService.getById(id));
        getServletContext().getRequestDispatcher("/JSP/nuevo-producto.jsp").forward(req, resp);
    } 

}
