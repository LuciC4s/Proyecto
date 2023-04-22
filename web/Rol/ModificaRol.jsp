<%-- 
    Document   : ModificaRol
    Created on : 21/04/2023, 06:31:59 PM
    Author     : Lucia Pérez
--%>

<%@page import="org.models.ModelRol"%>
<%@page import="org.dao.DaoRol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form id="form-work" class="" name="form-work" action="ControllerRol" method="get">
                <h1>Modifica Rol</h1>
                <div class="form-group" >  
                    <%
                        DaoRol daoRol = new DaoRol();
                        //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                        int idRol = Integer.parseInt((String) request.getAttribute("idRol"));
                        ModelRol rol = new ModelRol();
                        rol = daoRol.list(idRol);
                    %>

                    <input type="hidden" name="usuario" value="<%= rol.getId_rol()%>">
                    <div class="col-md-3">
                        <label class="control-label" for="nombre">Nombre</label>
                        <input name="nombre" class="form-control" placeholder="Nombres" type="text" value ="<%= rol.getNombre()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Apellido">Apellido</label>
                        <input name="nombre" class="form-control" placeholder="Apellido" type="text" value ="<%= rol.getDescripcion()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Creacion">Fecha Creacion</label>
                        <input name="password" class="form-control" placeholder="Fecha Creacion" type="text" value="<%= rol.getFecha_crea()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Creacion">Usuario Creacion</label>
                        <input name="password" class="form-control" placeholder="Usuario Creacion" type="text" value="<%= rol.getUsuario_crea()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Modifica">Fecha Modifica</label>
                        <input name="password" class="form-control" placeholder="Fecha Modifica" type="text" value="<%= rol.getFecha_mod()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Modifica">Usuario Modifica</label>
                        <input name="password" class="form-control" placeholder="Usuario Modifica" type="text" value="<%= rol.getUsuario_mod()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="estado">Estado</label>
                        <select name="estado" class="form-control">
                            <option value="1" selected="">Activo</option>
                            <option value="0" >Inactivo</option>
                        </select>
                        <%--    <input name="estado" class="form-control" placeholder="Estado" type="text"> --%>
                    </div>
                    <br><br><br>
                    <br><br><br><br>
                    <div class="col-md-3">
                        <button type="submit" name="accion" value="update" class="btn btn-success btn-lg btn-block info">Actualizar</button>
                    </div>
                    <div class="col-md-3">
                        <a class="btn btn-success btn-lg btn-block info" href="ControllerRol?accion=read"  > Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
