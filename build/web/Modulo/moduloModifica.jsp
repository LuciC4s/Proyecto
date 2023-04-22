<%-- 
    Document   : usuarioModifica
    Created on : 20/02/2023, 19:46:06
    Author     : Usuario
--%>
<%@page import="org.models.ModelModulo"%>
<%@page import="org.dao.DaoModulo"%>
<%@page import="org.models.ModelUsuario"%>
<%@page import="org.dao.DaoUsuario"%>
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
            <form id="form-work" class="" name="form-work" action="ControllerUsuario" method="get">
                <h1>Modifica Modulo</h1>
                <div class="form-group" >  
                    <%
                        DaoModulo daoModulo = new DaoModulo();
                        //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                        int idMod = Integer.parseInt((String) request.getAttribute("idMod"));
                        ModelModulo modulo = new ModelModulo();
                        modulo = daoModulo.list(idMod);
                    %>

                    <input type="hidden" name="id_modulo" value="<%= modulo.getId_modulo()%>">
                    <div class="col-md-3">
                        <label class="control-label" for="nombre">Nombre</label>
                        <input name="nombre" class="form-control" placeholder="Nombres" type="text" value ="<%= modulo.getNombre()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Descripcion">Descripcion</label>
                        <input name="Descripcion" class="form-control" placeholder="Descripcion" type="text" value ="<%= modulo.getDescripcion()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Path">Path</label>
                        <input name="Path" class="form-control" placeholder="Path" type="text" value="<%= modulo.getPath()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="password">Nivel</label>
                        <input name="Nivel" class="form-control" placeholder="Nivel" type="text" value="<%= modulo.getNivel()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="id rol">Orden</label>
                        <input name="Orden" class="form-control" placeholder="Orden" type="text" value="<%= modulo.getOrden()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="id rol">Modulo_padre</label>
                        <input name="Id_modulo_padre" class="form-control" placeholder="Modulo_padre" type="text" value="<%= modulo.getId_modulo_padre()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Creacion">Fecha Creacion</label>
                        <input name="password" class="form-control" placeholder="Fecha Creacion" type="text" value="<%= modulo.getFecha_crea()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Creacion">Usuario Creacion</label>
                        <input name="password" class="form-control" placeholder="Usuario Creacion" type="text" value="<%= modulo.getUsuario_crea()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Modifica">Fecha Modifica</label>
                        <input name="password" class="form-control" placeholder="Fecha Modifica" type="text" value="<%= modulo.getFecha_mod()%>">
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Modifica">Usuario Modifica</label>
                        <input name="password" class="form-control" placeholder="Usuario Modifica" type="text" value="<%= modulo.getUsuario_mod()%>">
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
                        <a class="btn btn-success btn-lg btn-block info" href="ControllerUsuario?accion=read"  > Regresar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
