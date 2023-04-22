
<%@page import="org.models.ModelModulo"%>
<%@page import="org.dao.DaoModulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelUsuario"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Modulo</title>
    </head>
    <body>
        <div class="container">            
            <h1>Consulta Modulo</h1>
            
            <div class="navbar">
                <!--style="margin-left: 80px"-->
                <form class="form-inline" action="ControllerModulo?accion=buscar">
                    <a class="btn btn-success" href="ControllerModulo?accion=nuevo"> Agregar Nuevo</a>
                    <input type="submit" name="accion" value="buscar" class="btn btn-out">
                    <input type="search" name="input" class="form-control" >
                </form>
            </div>
                <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Nombre</th>
                            <th class="text-center">Descripcion</th>
                            <th class="text-center">Path</th>
                            <th class="text-center">Nivel</th>
                            <th class="text-center">Orden</th>
                            <th class="text-center">id_modulo_padre</th>
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
                        DaoModulo daoModulo = new  DaoModulo();
                        List<ModelModulo> lstUsuario = daoModulo.listar();
                        Iterator<ModelModulo> iteratorUsuario = lstUsuario.iterator();
                        ModelModulo modulo = null;
                        while (iteratorUsuario.hasNext()){
                            modulo = iteratorUsuario.next();                        
                        %> 
                        <tr>
                            <td class="text-center"><%= modulo.getId_modulo()%></td>
                            <td class="text-center"><%= modulo.getNombre()%></td>
                            <td class="text-center"><%= modulo.getDescripcion()%></td>
                            <td class="text-center"><%= modulo.getPath()%></td>
                            <td class="text-center"><%= modulo.getNivel()%></td>   
                            <td class="text-center"><%= modulo.getOrden()%></td>
                            <td class="text-center"><%= modulo.getId_modulo_padre()%></td>
                            <td class="text-center"><%= modulo.getFecha_crea()%></td>
                            <td class="text-center"><%= modulo.getUsuario_crea()%></td>
                            <td class="text-center"><%= modulo.getFecha_mod()%></td>
                            <td class="text-center"><%= modulo.getUsuario_mod()%></td> 
                            <td class="text-center"><%= modulo.getActivo()%></td>
                            <td class="text-center">                                
                                <a type="button" class="btn btn-danger" href="ControllerModulo?accion=editar&id=<%=modulo.getId_modulo()%>">Editar</a>
                                <a type="button" class="btn btn-danger" href="ControllerModulo?accion=delete&id=<%=modulo.getId_modulo()%>">Eliminar</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
        </div>
    </body>
</html>
