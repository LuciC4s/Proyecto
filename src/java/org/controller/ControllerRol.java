/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoRol;
import org.models.ModelRol;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControllerRol", urlPatterns = {"/ControllerRol"})
public class ControllerRol extends HttpServlet {
    String listar="Rol/consultarRol.jsp";
    String add="Rol/IngresoRol.jsp";
    String edit="Rol/ModificaRol.jsp";
    String delete="";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerRol</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerRol at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String acceso="";        
        String action = request.getParameter("accion");        
        
        ModelRol rol = new ModelRol();
        DaoRol daoRol = new DaoRol();
        
        
        switch (action){
            case "read":
                acceso = listar;
            break;
            
            case "nuevo":
                acceso=add;
            break;
                
            case "create" :                
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                Boolean activo = Boolean.parseBoolean(request.getParameter("activo"));
                String usuario_crea = request.getParameter("usuario_crea");
                String usuario_mod = request.getParameter("usuario_mod");
                int fecha_crea = Integer.parseInt(request.getParameter("fecha_crea"));
                int fecha_mod = Integer.parseInt(request.getParameter("fecha_mod"));

                rol.setNombre(nombre);
                rol.setDescripcion(descripcion);
                rol.setActivo(activo);
                rol.setUsuario_crea(usuario_crea);
                rol.setUsuario_mod(usuario_mod);
                rol.setFecha_crea(fecha_crea);
                rol.setFecha_mod(fecha_mod);

                daoRol.insertar(rol);
                
                acceso = listar;
            break;
            case "editar":
                //obtenemos el id de la fila que estamos seleccionando y se la pasamos al formulario de editar
                request.setAttribute("idRol", request.getParameter("id"));
                //Redireccionamos a la pagina de edición
                acceso = edit;
            break;            
            case "update" :
                int id_rol = Integer.parseInt(request.getParameter("id_rol"));
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                activo = Boolean.parseBoolean(request.getParameter("activo"));
                usuario_crea = request.getParameter("usuario_crea");
                usuario_mod = request.getParameter("usuario_mod");
                fecha_crea = Integer.parseInt(request.getParameter("fecha_crea"));
                fecha_mod = Integer.parseInt(request.getParameter("fecha_mod"));
                
                rol.setId_rol(id_rol);
                rol.setNombre(nombre);
                rol.setDescripcion(descripcion);
                rol.setActivo(activo);
                rol.setUsuario_crea(usuario_crea);
                rol.setUsuario_mod(usuario_mod);
                rol.setFecha_crea(fecha_crea);
                rol.setFecha_mod(fecha_mod);
                
                daoRol.modificar(rol);
                
                acceso = listar;                
            break;
            case "delete":
                id_rol = Integer.parseInt(request.getParameter("id"));
                rol.setId_rol(id_rol);
                daoRol.eliminar(rol);
                
                acceso=listar;
            break;
            case "buscar":
                int busqueda = Integer.parseInt(request.getParameter("input"));
                request.setAttribute("idRol", request.getParameter("input"));
                List<ModelRol> lista=daoRol.search(busqueda);
                request.setAttribute("datos", lista);                
                request.getRequestDispatcher("Rol/rolSearch.jsp").forward(request, response);
                
            break;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
