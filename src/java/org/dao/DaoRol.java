/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudRol;
import org.models.ModelRol;

/**
 *
 * @author Usuario
 */
public class DaoRol implements CrudRol {

    //Se crea un objeto publico del Cliente
    ModelRol rol = new ModelRol();
    //Variable para crear las sentencias SQL
    String strSql = "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;

    @Override
    public List listar() {
        ArrayList<ModelRol> lstRol = new ArrayList<>();
        try {
            /*strSql = "SELECT P.ID_ROL, P.NOMBRE, P.DESCRIPCION, P.ACTIVO, P.USUARIO_CREA, P.USUARIO_MOD, P.FECHA_CREA, P.FECHA_MOD,"
                    + "TP.ID_USUARIO CATEGORIA, CASE WHEN P.ACTIVO = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END DESCESTADO "
                    + "FROM	ROL P "
                    + "JOIN	USUARIO TP "
                    + "ON		P.USUARIO_CREA = TP.USUARIO_CREA "
                    + "ON		P.USUARIO_MOD = TP.USUARIO_MOD "
                    + "ON		P.FECHA_CREA = TP.FECHA_CREA "
                    + "ON		P.FECHA_MOD = TP.FECHA_MOD ";*/
            strSql = "SELECT * FROM ROL";

            System.out.println("Query Rol: " + strSql);
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModelRol ro = new ModelRol();
                ro.setId_rol(rs.getInt("ID_ROL"));
                ro.setNombre(rs.getString("NOMBRE"));
                ro.setDescripcion(rs.getString("DESCRIPCION"));
                ro.setActivo(rs.getBoolean("ACTIVO"));
                ro.setUsuario_crea(rs.getString("USUARIO_CREA"));
                ro.setUsuario_mod(rs.getString("USUARIO_MOD"));
                ro.setFecha_crea(rs.getInt("FECHA_CREA"));
                ro.setFecha_mod(rs.getInt("FECHA_MOD"));
                lstRol.add(ro);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstRol;
    }

    @Override
    public ModelRol list(int id) {
        ModelRol rol = new ModelRol();
        try {
            strSql = "SELECT * FROM ROL WHERE ID_ROL =  " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {

                rol.setId_rol(rs.getInt("ID_ROL"));
                rol.setNombre(rs.getString("NOMBRE"));
                rol.setDescripcion(rs.getString("DESCRIPCION"));
                rol.setActivo(rs.getBoolean("ACTIVO"));
                rol.setUsuario_crea(rs.getString("USUARIO_CREA"));
                rol.setUsuario_mod(rs.getString("USUARIO_MOD"));
                rol.setFecha_crea(rs.getInt("FECHA_CREA"));
                rol.setFecha_mod(rs.getInt("FECHA_MOD"));

            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rol;
    }

    @Override
    public boolean insertar(ModelRol rol) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO ROL (ID_ROL, NOMBRE, DESCRIPCION, ACTIVO, USUARIO_CREA, USUARIO_MOD, FECHA_CREA, FECHA_MOD) "
                + "VALUES ( (SELECT ISNULL(MAX(ID_ROL),0) + 1 FROM ROL), "
                + "'" + rol.getNombre() + "', "
                + "" + rol.getDescripcion() + ", "
                + "" + rol.getActivo() + ", "
                + "" + rol.getUsuario_crea() + ", "
                + "" + rol.getUsuario_mod() + ", "
                + "" + rol.getFecha_crea() + ", "
                + "" + rol.getFecha_mod() + ""
                + ")";
        System.out.println("Insertar rol: " + strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelRol rol) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE ROL "
                + "SET  "
                + "NOMBRE = '" + rol.getNombre() + "', "
                + "DESCRIPCION = '" + rol.getDescripcion() + "', "
                + "ACTIVO = " + rol.getActivo() + ", "
                + "USUARIO_CREA = " + rol.getUsuario_crea() + ", "
                + "USUARIO_MOD = " + rol.getUsuario_mod() + ", "
                + "FECHA_CREA = " + rol.getFecha_crea() + ", "
                + "FECHA_MOD = " + rol.getFecha_mod() + " "
                + "WHERE ID_ROL = " + rol.getId_rol();
        System.out.println("Rol Modifica: " + strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelRol rol) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE ROL WHERE ID_ROL = " + rol.getId_rol();

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List search(int id_rol) {
        ArrayList<ModelRol> lista = new ArrayList<>();
        try {
            strSql = "SELECT * FROM ROL WHERE ID_ROL LIKE '%" + id_rol + "%'";
            System.out.println("Query Rol: " + strSql);
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModelRol ro = new ModelRol();
                ro.setId_rol(rs.getInt("ID_ROL"));
                lista.add(ro);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
