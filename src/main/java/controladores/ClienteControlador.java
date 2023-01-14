package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ClienteDTO;
import services.ClienteService;

@WebServlet(name="ClienteServlet", urlPatterns = "/clientes/*")
public class ClienteControlador extends HttpServlet{
    
    ClienteService service;

    @Override
    public void init() throws ServletException {
        service = new ClienteService(new ClienteDAO(getServletContext()));
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String correo = req.getParameter("correo");
        String genero = req.getParameter("genero");
        String dir = req.getParameter("direccion");
        ClienteDTO c = new ClienteDTO(nombre, apellido, genero, correo, dir);
        service.save(c);
        listar(req, resp, service.getAll());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI();
        if(action.equalsIgnoreCase("/banco/clientes")){
           listar(req, resp, service.getAll());
        }else if(action.equalsIgnoreCase("/banco/clientes/nuevo")){
            nuevo(req, resp);   
        }else if(action.equalsIgnoreCase("/banco/clientes/buscar")){
            buscar(req, resp);
        }
        /**
         * req.getParameter("name")
         * /personas?firstName=Sergio&lastName=Suarique
         * req.getParameter("firstName"); 
         * req.getParameter("lastName");
         */
        

        // resp.sendRedirect("https://google.com");
        
    }

    public void listar(HttpServletRequest req, HttpServletResponse resp,List<ClienteDTO> c)throws ServletException, IOException {
        req.setAttribute("clientes", c);
        getServletContext().getRequestDispatcher("/JSP/clientes.jsp").forward(req, resp);
    }
    public void nuevo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/JSP/nuevo.jsp").forward(req, resp);
    }
    public void buscar(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<ClienteDTO> c;
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        if(id != null && !id.isEmpty()){
            c = new ArrayList<>();
            c.add(service.getById(Long.parseLong(id)));
        }else{
            c = service.getClientByNameAndLastName(name, lastName);
        }
        listar(req, resp, c);
    }
}