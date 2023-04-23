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
import org.dao.DaoPermiso;
import org.models.ModelPermiso;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControllerPermiso", urlPatterns = {"/ControllerPermiso"})
public class ControllerPermiso extends HttpServlet {
    String listar="Permiso/ConsultarPermiso.jsp";
    String add="Permiso/IngresoPermiso.jsp";
    String edit="Permiso/ModificaPermiso.jsp";
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
            out.println("<title>Servlet ControllerPermiso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerPermiso at " + request.getContextPath() + "</h1>");
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
        
        ModelPermiso permiso = new ModelPermiso();
        DaoPermiso daoPermiso = new DaoPermiso();
        
        
        switch (action){
            case "read":
                acceso = listar;
            break;
            
            case "nuevo":
                acceso=add;
            break;
                
            case "create" :                
                int id_modulo = Integer.parseInt(request.getParameter("idmodulo"));
                int id_rol = Integer.parseInt(request.getParameter("idrol"));
                int fecha_crea = Integer.parseInt(request.getParameter("fecha_crea"));
                int fecha_mod = Integer.parseInt(request.getParameter("fecha_mod"));
                //int usuario_crea = Integer.parseInt(request.getParameter("usuario_crea"));
                //int usuario_mod = Integer.parseInt(request.getParameter("usuario_mod"));
                int activo = Integer.parseInt(request.getParameter("estado"));
               
                String usuario_crea = request.getParameter("usuario_crea");
                String usuario_mod = request.getParameter("usuario_mod");
                

                permiso.setId_rol(id_rol);
                permiso.setId_modulo(id_modulo);
                //permiso.s(id_rol);
                permiso.setFecha_crea(fecha_crea);
                permiso.setFecha_mod(fecha_mod);
                permiso.setUsuario_crea(usuario_crea);
                permiso.setUsuario_mod(usuario_mod);               
                permiso.setActivo(activo);
                
                daoPermiso.insertar(permiso);
                
                acceso = listar;
            break;
            case "editar":
                //obtenemos el id de la fila que estamos seleccionando y se la pasamos al formulario de editar
                request.setAttribute("idPermiso", request.getParameter("id"));
                //Redireccionamos a la pagina de edición
                acceso = edit;
            break;            
            case "update" :
                int id_permiso = Integer.parseInt(request.getParameter("id_permiso"));
                id_modulo = Integer.parseInt(request.getParameter("idmodulo"));
                id_rol = Integer.parseInt(request.getParameter("idrol"));
                fecha_crea = Integer.parseInt(request.getParameter("fecha_crea"));
                fecha_mod = Integer.parseInt(request.getParameter("fecha_mod"));
                activo = Integer.parseInt(request.getParameter("estado"));
                
                 usuario_crea = request.getParameter("usuario_crea");
                 usuario_mod = request.getParameter("usuario_mod");
                
                permiso.setId_rol(id_permiso);
                permiso.setId_rol(id_rol);
                permiso.setId_modulo(id_modulo);
                permiso.setId_rol(id_rol);
                permiso.setFecha_crea(fecha_crea);
                permiso.setFecha_mod(fecha_mod);
                permiso.setUsuario_crea(usuario_crea);
                permiso.setUsuario_mod(usuario_mod);               
                permiso.setActivo(activo);
                
                daoPermiso.modificar(permiso);
                
                acceso = listar;                
            break;
            case "delete":
                id_permiso = Integer.parseInt(request.getParameter("id"));
                permiso.setId_permido(id_permiso);
                daoPermiso.eliminar(permiso);
                
                acceso=listar;
            break;
            case "buscar":
                int busqueda = Integer.parseInt(request.getParameter("input"));
                request.setAttribute("idPermiso", request.getParameter("input"));
                List<ModelPermiso> lista=daoPermiso.search(busqueda);
                request.setAttribute("datos", lista);                
                request.getRequestDispatcher("Permiso/permisoSearch.jsp").forward(request, response);
                
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
