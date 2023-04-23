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
import org.dao.DaoUsuario;
import org.models.ModelUsuario;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

    String listar="Usuario/consultaUsuario.jsp";
    String add="Usuario/usuarioIngreso.jsp";
    String edit="Usuario/usuarioModifica.jsp";
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
            out.println("<title>Servlet ControllerUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
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
        
        ModelUsuario usuario = new ModelUsuario();
        DaoUsuario daoUsuario = new DaoUsuario();
        
        switch (action){
            case "read":
                acceso = listar;
            break;            
            case "nuevo":
                acceso=add;
            break;
            case "create":
                //usuario.setId_usuario(Integer.parseInt(request.getParameter("usuarios")));
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellido(request.getParameter("apellido"));
                usuario.setUsuario(request.getParameter("usuarios"));
                usuario.setPassword(request.getParameter("password"));
                usuario.setId_rol(Integer.parseInt(request.getParameter("idrol")));
                usuario.setFecha_crea(Integer.parseInt(request.getParameter("fechacrea")));
                usuario.setActivo(Integer.parseInt(request.getParameter("estado")));
                usuario.setFecha_mod(Integer.parseInt(request.getParameter("fechamod")));
                usuario.setUsuario_crea(request.getParameter("usuariocrea"));
                usuario.setUsuario_mod(request.getParameter("usuariomod"));
                usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                daoUsuario.insertar(usuario);
                acceso = listar;
            break;
            case "editar":
                request.setAttribute("idUsu", request.getParameter("id"));
                acceso = edit;
            break;
            case "update" :
                usuario.setId_usuario(Integer.parseInt(request.getParameter("usuario")));
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellido(request.getParameter("apellido"));
                usuario.setUsuario(request.getParameter("usuarios"));
                usuario.setPassword(request.getParameter("password"));
                usuario.setId_rol(Integer.parseInt(request.getParameter("idrol")));
                usuario.setFecha_crea(Integer.parseInt(request.getParameter("fechacrea")));
                usuario.setActivo(Integer.parseInt(request.getParameter("estado")));
                usuario.setFecha_mod(Integer.parseInt(request.getParameter("fechamod")));
                usuario.setUsuario_crea(request.getParameter("usuariocrea"));
                usuario.setUsuario_mod(request.getParameter("usuariomod"));
                
                daoUsuario.modificar(usuario);
                acceso = listar;                
            break;
            case "delete":
                usuario.setId_usuario(Integer.parseInt(request.getParameter("id")));
                daoUsuario.eliminar(usuario);
                acceso=listar;
            break;
            case "buscar":
                int busqueda = Integer.parseInt(request.getParameter("input"));
                request.setAttribute("idUsu", request.getParameter("input"));
                List<ModelUsuario> lista=daoUsuario.search(busqueda);
                request.setAttribute("datos", lista);
                request.getRequestDispatcher("Usuario/usuarioSearch.jsp").forward(request, response);
                
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
