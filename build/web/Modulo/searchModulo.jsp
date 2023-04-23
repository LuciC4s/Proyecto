<%-- 
    Document   : modificarModulo
    Created on : 22/04/2023, 09:44:31 PM
    Author     : Lucia Pérez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelModulo"%>
<%@page import="org.dao.DaoModulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Busqueda Usuario</title>
    </head>
    <body>
        <div class="container">            
            <h1>Usuarios</h1>
            <a class="btn btn-success" href="ControllerModulo?accion=nuevo"  > Agregar Nuevo</a>
            <a class="btn btn-success" href="ControllerModulo?accion=read"  > Regresar</a>
            <br><br>
            <form id="form-work" class="" name="form-work" action="ControllerModulo" method="get">                  
                   
                      <%
                          DaoModulo daoModulo = new  DaoModulo();
                          //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                          int idUsuario = Integer.parseInt((String) request.getAttribute("idUsu"));
                          ModelModulo modulo = new ModelModulo();
                          modulo = daoModulo.list(idUsuario);
                      %>
                      
                      <input type="hidden" name="usuario" value="<%= modulo.getId_modulo()%>">
                     </form>
                     
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
                    <%
                        DaoModulo daoModuloo = new  DaoModulo();
                        List<ModelModulo> lstModulo = daoModulo.listar();
                        Iterator<ModelModulo> iteratorModulo = lstModulo.iterator();
                        ModelModulo moduloo = null;
                            moduloo = iteratorModulo.next();                        
                     %> 
                       <tbody>
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
                    </tbody>
                </table>
        </div>
    </body>
</html>
