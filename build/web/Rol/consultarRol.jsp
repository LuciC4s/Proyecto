<%-- 
    Document   : consultarRol
    Created on : 21/04/2023, 06:31:21 PM
    Author     : Lucia Pérez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelRol"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoRol"%>
<jsp:include page="../plantillaIndex.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">            
            <h1>Rol</h1>

            <div class="navbar">
                <!--style="margin-left: 80px"-->
                <form class="form-inline" action="ControllerRol?accion=buscar">
                    <a class="btn btn-success" href="ControllerRol?accion=nuevo"  > Agregar Nuevo</a>
                    <input type="submit" name="accion" value="buscar" class="btn btn-out">
                    <input type="search" name="input" class="form-control" >
                </form>
            </div>
            <table border="1" width="1" cellspacing="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Descripción</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">Fecha Crea</th>
                        <th class="text-center">Usuario Crea</th>
                        <th class="text-center">Fecha Modifica</th>
                        <th class="text-center">Usuario Modifica</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>                                        
                <tbody>
                    <%
                        DaoRol daoRol = new DaoRol();
                        List<ModelRol> lstUsuario = daoRol.listar();
                        Iterator<ModelRol> iteratorUsuario = lstUsuario.iterator();
                        ModelRol rol = null;
                        while (iteratorUsuario.hasNext()) {
                            rol = iteratorUsuario.next();
                    %> 
                    <tr>
                        <td class="text-center"><%= rol.getId_rol()%></td>
                        <td class="text-center"><%= rol.getNombre()%></td>
                        <td class="text-center"><%= rol.getDescripcion()%></td>
                        <td class="text-center"><%= rol.getActivo()%></td>
                        <td class="text-center"><%= rol.getFecha_crea()%></td>
                        <td class="text-center"><%= rol.getUsuario_crea()%></td>
                        <td class="text-center"><%= rol.getFecha_mod()%></td>
                        <td class="text-center"><%= rol.getUsuario_mod()%></td> 


                        <td class="text-center">                                
                            <a type="button" class="btn btn-danger" href="ControllerRol?accion=editar&id=<%=rol.getId_rol()%>">Editar</a>
                            <a type="button" class="btn btn-danger" href="ControllerRol?accion=delete&id=<%=rol.getId_rol()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
