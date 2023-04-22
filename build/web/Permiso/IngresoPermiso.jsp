<%-- 
    Document   : IngresoPermiso
    Created on : 21/04/2023, 06:33:18 PM
    Author     : Lucia Pérez
--%>

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

                <h1>Ingreso Permisos</h1>

                <div class="form-group" >                      
                    <input type="hidden" name="id_permido" >
                    <div class="col-md-3">
                        <label class="control-label" for="id_modulo">Id modulo</label>
                        <input name="id_modulo" class="form-control" placeholder="id_modulo" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="id_rol">Id rol</label>
                        <input name="id_rol" class="form-control" placeholder="id_rol" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="fecha_crea">Fecha crea</label>
                        <input name="fecha_crea" class="form-control" placeholder="fecha_crea" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="usuario_crea">Usuario crea</label>
                        <input name="usuario_crea" class="form-control" placeholder="usuario_crea" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="fecha_mod">Fecha Modifica</label>
                        <input name="fecha_mod" class="form-control" placeholder="fecha_mod" type="text" >
                    </div>
                    <br><br><br>
                    <div class="col-md-3">
                        <label class="control-label" for="usuario_mod">Usuario Modifica</label>
                        <input name="usuario_mod" class="form-control" placeholder="usuario_mod" type="text" >
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
                        <input name="password" class="form-control" placeholder="Codigo" type="text" >
                    </div>
                    <br><br><br>
                    <br><br><br><br>
                    <div class="col-md-3">
                        <button type="submit" name="accion" value="create" class="btn btn-success btn-lg btn-block info">Guardar</button>
                    </div>
                                        <div class="col-md-3">
                        <a class="btn btn-success btn-lg btn-block info" href="ControllerPermiso?accion=read"  > Regresar</a>
                    </div>
                </div>             
            </form>
        </div>
    </body>
</html>
