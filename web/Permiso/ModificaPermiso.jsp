<%-- 
    Document   : ModificaPermiso
    Created on : 21/04/2023, 06:33:31 PM
    Author     : Lucia Pérez
--%>

<%@page import="org.models.ModelPermiso"%>
<%@page import="org.dao.DaoPermiso"%>
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
            <form id="form-work" class="" name="form-work" action="ControllerPermiso" method="get">
                <h1>Modifica Permiso</h1>
                <div class="form-group" >  
                    <%
                        DaoPermiso daoPermiso = new DaoPermiso();
                        //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                        int idPermiso = Integer.parseInt((String) request.getAttribute("idPermiso"));
                        ModelPermiso permiso = new ModelPermiso();
                        permiso = daoPermiso.list(idPermiso);
                    %>

                    <input type="hidden" name="id_permiso" value="<%= permiso.getId_permido()%>">
                    <div class="col-md-3">
                        <label class="control-label" for="Id_modulo">Id modulo</label>
                        <input name="idmodulo" class="form-control" placeholder="Id_modulo" type="text" value ="<%= permiso.getId_modulo()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="getId_rol">Id rol</label>
                        <input name="idrol" class="form-control" placeholder="getId_rol" type="text" value ="<%= permiso.getId_rol()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Creacion">Fecha Creacion</label>
                        <input name="fecha_crea" class="form-control" placeholder="Fecha Creacion" type="text" value="<%= permiso.getFecha_crea()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Creacion">Usuario Creacion</label>
                        <input name="usuario_crea" class="form-control" placeholder="Usuario Creacion" type="text" value="<%= permiso.getUsuario_crea()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Modifica">Fecha Modifica</label>
                        <input name="fecha_mod" class="form-control" placeholder="Fecha Modifica" type="text" value="<%= permiso.getFecha_mod()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Modifica">Usuario Modifica</label>
                        <input name="usuario_mod" class="form-control" placeholder="Usuario Modifica" type="text" value="<%= permiso.getUsuario_mod()%>">
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
                        <a class="btn btn-success btn-lg btn-block info" href="ControllerPermiso?accion=read"  > Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
