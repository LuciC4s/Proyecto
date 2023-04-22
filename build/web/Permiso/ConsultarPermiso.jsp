<%-- 
    Document   : ConsultarPermiso
    Created on : 21/04/2023, 06:33:45 PM
    Author     : Lucia Pérez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelPermiso"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoPermiso"%>
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
            <h1>Consultar Permisos</h1>
            
            <div class="navbar">
                <!--style="margin-left: 80px"-->
                <form class="form-inline" action="ControllerPermiso?accion=buscar">
                    <a class="btn btn-success" href="ControllerPermiso?accion=nuevo"  > Agregar Nuevo</a>
                    <input type="submit" name="accion" value="buscar" class="btn btn-out">
                    <input type="search" name="input" class="form-control" >
                </form>
            </div>
                <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Id modulo</th>
                            <th class="text-center">Id rol</th>
                            <th class="text-center">Fecha Crea</th>
                            <th class="text-center">Usuario Crea</th>
                            <th class="text-center">Fecha Modifica</th>
                            <th class="text-center">Usuario Modifica</th>
                            <th class="text-center">Estado</th>    
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>                                        
                    <tbody>
                        <%
                        DaoPermiso daoPermiso = new  DaoPermiso();
                        List<ModelPermiso> lstUsuario = daoPermiso.listar();
                        Iterator<ModelPermiso> iteratorUsuario = lstUsuario.iterator();
                        ModelPermiso permiso = null;
                        while (iteratorUsuario.hasNext()){
                            permiso = iteratorUsuario.next();                        
                        %> 
                        <tr>
                            <td class="text-center"><%= permiso.getId_permido()%></td>
                            <td class="text-center"><%= permiso.getId_modulo()%></td>
                            <td class="text-center"><%= permiso.getId_rol()%></td>
                            <td class="text-center"><%= permiso.getFecha_crea()%></td>
                            <td class="text-center"><%= permiso.getUsuario_crea()%></td>
                            <td class="text-center"><%= permiso.getFecha_mod()%></td>
                            <td class="text-center"><%= permiso.getUsuario_mod()%></td> 
                            <td class="text-center"><%= permiso.getActivo()%></td>
                            <td class="text-center">                                
                                <a type="button" class="btn btn-danger" href="ControllerPermiso?accion=editar&id=<%=permiso.getId_permido()%>">Editar</a>
                                <a type="button" class="btn btn-danger" href="ControllerPermiso?accion=delete&id=<%=permiso.getId_permido()%>">Eliminar</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
        </div>
    </body>
</html>
