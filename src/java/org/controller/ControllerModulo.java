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
import org.dao.DaoModulo;
import org.models.ModelModulo;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControllerModulo", urlPatterns = {"/ControllerModulo"})
public class ControllerModulo extends HttpServlet {

    String listar="Modulo/consultaModulo.jsp";
    String add="Modulo/ingresoModulo.jsp";
    String edit="Modulo/moduloModifica.jsp";
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
            out.println("<title>Servlet ControllerModulo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerModulo at " + request.getContextPath() + "</h1>");
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
        
        ModelModulo modulo = new ModelModulo();
        DaoModulo daoModulo = new DaoModulo();
        
        switch (action){
            case "read":
                acceso = listar;
            break;            
            case "nuevo":
                acceso=add;
            break;
            case "create":
                //modulo.setId_modulo(Integer.parseInt(request.getParameter("modulos")));
                modulo.setNombre(request.getParameter("nombre"));
                modulo.setDescripcion(request.getParameter("descripcion"));
                modulo.setPath(request.getParameter("path"));
                modulo.setNivel(Integer.parseInt(request.getParameter("nivel")));
                modulo.setId_modulo_padre(Integer.parseInt(request.getParameter("idmodulopadre")));
                modulo.setFecha_crea(Integer.parseInt(request.getParameter("fechacrea")));
                modulo.setFecha_mod(Integer.parseInt(request.getParameter("fechamod")));                      
                modulo.setUsuario_crea(request.getParameter("usuariocrea"));
                modulo.setUsuario_mod(request.getParameter("usuariomod"));
                modulo.setActivo(Integer.parseInt(request.getParameter("activo")));
                daoModulo.insertar(modulo);
                acceso = listar;
            break;
            case "editar":
                request.setAttribute("idMod", request.getParameter("id"));
                acceso = edit;
            break;
            case "update" :
                modulo.setId_modulo(Integer.parseInt(request.getParameter("modulos")));
                modulo.setNombre(request.getParameter("nombre"));
                modulo.setDescripcion(request.getParameter("descripcion"));
                modulo.setPath(request.getParameter("path"));
                modulo.setNivel(Integer.parseInt(request.getParameter("nivel")));
                modulo.setId_modulo_padre(Integer.parseInt(request.getParameter("idmodulopadre")));
                modulo.setFecha_crea(Integer.parseInt(request.getParameter("fechacrea")));
                modulo.setFecha_mod(Integer.parseInt(request.getParameter("fechamod")));                      
                modulo.setUsuario_crea(request.getParameter("usuariocrea"));
                modulo.setUsuario_mod(request.getParameter("usuariomod"));
                 modulo.setActivo(Integer.parseInt(request.getParameter("activo")));
                
                daoModulo.modificar(modulo);
                acceso = listar;                
            break;
            case "delete":
                modulo.setId_modulo(Integer.parseInt(request.getParameter("id")));
                daoModulo.eliminar(modulo);
                acceso=listar;
            break;
            case "buscar":
                int busqueda = Integer.parseInt(request.getParameter("input"));
                request.setAttribute("idMod", request.getParameter("input"));
                List<ModelModulo> lista=daoModulo.search(busqueda);
                request.setAttribute("datos", lista);
                request.getRequestDispatcher("Modulo/moduloSearch.jsp").forward(request, response);
                
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
