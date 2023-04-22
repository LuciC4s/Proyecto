<%-- 
    Document   : usuarioIngreso
    Created on : 20/02/2023, 19:45:43
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Usuario</title>
    </head>
    <body>
        <div class="container">
            <form id="form-work" class="" name="form-work" action="ControllerUsuario" method="get">
                <h1>Ingreso Usuarios</h1>
                <div class="form-group" >                      
                    <input type="hidden" name="usuario" >
                    <div class="col-md-3">
                        <label class="control-label" for="nombre">Nombre</label>
                        <input name="nombre" class="form-control" placeholder="Nombres" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Apellido">Apellido</label>
                        <input name="apellido" class="form-control" placeholder="Apellido" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="usuarios">Usuario</label>
                        <input name="usuarios" class="form-control" placeholder="Usuario" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="password">Password</label>
                        <input name="password" class="form-control" placeholder="Password" type="password" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="id rol">Id Rol</label>
                        <input name="idrol" class="form-control" placeholder="Id rol" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Fecha Creacion">Fecha Creacion</label>
                        <input name="fechacrea" class="form-control" placeholder="Fecha Creacion" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="usuario_crea">Usuario Creacion</label>
                        <input name="usuariocrea" class="form-control" placeholder="Usuario Creacion" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="fecha_mod">Fecha Modifica</label>
                        <input name="fechamod" class="form-control" placeholder="Fecha Modifica" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="Usuario Modifica">Usuario Modifica</label>
                        <input name="usuariomod" class="form-control" placeholder="Usuario Modifica" type="text" >
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
                    <div class="col-md-3">
                        <label class="control-label" for="codigo">Codigo</label>
                        <input name="codigo" class="form-control" placeholder="Codigo" type="text" >
                    </div>
                    <br><br><br>
                    <br><br><br><br>
                    <div class="col-md-3">
                        <button type="submit" name="accion" value="create" class="btn btn-success btn-lg btn-block info">Guardar</button>
                    </div>
                                        <div class="col-md-3">
                        <a class="btn btn-success btn-lg btn-block info" href="ControllerUsuario?accion=read"  > Regresar</a>
                    </div>
                </div>             
            </form>
        </div>
    </body>
</html>
