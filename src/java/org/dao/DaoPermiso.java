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
import org.interfaces.CrudPermiso;
import org.models.ModelPermiso;

/**
 *
 * @author Usuario
 */
public class DaoPermiso  implements  CrudPermiso {
    ModelPermiso permiso = new ModelPermiso();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;    
    @Override
    public List listar() {
        ArrayList<ModelPermiso> lstPermiso = new ArrayList<>();
         try {            
            strSql = /*"SELECT P.ID_PERMISO, P.ID_MODULO, P.ID_ROL, P.FECHA_CREA, P.FECHA_MOD, P.USUARIO_CREA, P.USUARIO_MOD, P.ACTIVO," + 
                     "TP.DESCRIPCION CATEGORIA, CASE WHEN P.ACTIVO = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END DESCESTADO " +
                     "FROM	PERMISO P " + 
                     "JOIN	MODULO TP " +
                     "ON		P.ID_MODULO = TP.ID_MODULO " +
                     "ON		P.USUARIO_CREA = TP.USUARIO_CREA " +
                     "ON		P.USUARIO_MOD = TP.USUARIO_MOD " +
                     "ON		P.FECHA_CREA = TP.FECHA_CREA " +
                     "ON		P.FECHA_MOD = TP.FECHA_MOD "*/
                    "SELECT * FROM PERMISO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelPermiso per = new ModelPermiso();
                per.setId_permido(rs.getInt("ID_PERMISO"));
                per.setId_modulo(rs.getInt("ID_MODULO"));
                per.setId_rol(rs.getInt("ID_ROL"));
                per.setFecha_crea(rs.getInt("FECHA_CREA"));
                per.setFecha_mod(rs.getInt("FECHA_MOD"));
                //per.setUsuario_crea(rs.getString("ID_ROL"));
                per.setFecha_crea(rs.getInt("FECHA_CREA"));
                per.setUsuario_crea(rs.getString("USUARIO_CREA"));
                per.setUsuario_mod(rs.getString("USUARIO_MOD"));          
                per.setActivo(rs.getInt("ACTIVO"));
                lstPermiso.add(per);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstPermiso;
    }

    @Override
    public ModelPermiso list(int id) {
        ModelPermiso permiso = new ModelPermiso();
        try {            
            strSql = "SELECT * FROM PERMISO WHERE ID_PERMISO =  " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                
                permiso.setId_permido(rs.getInt("ID_PERMISO"));
                permiso.setId_modulo(rs.getInt("ID_MODULO"));
                permiso.setId_rol(rs.getInt("ID_ROL"));
                permiso.setFecha_crea(rs.getInt("FECHA_CREA"));
                permiso.setFecha_mod(rs.getInt("FECHA_MOD"));
                //permiso.setUsuario_crea(rs.getString("ID_ROL"));
                permiso.setFecha_crea(rs.getInt("FECHA_CREA"));
                permiso.setUsuario_crea(rs.getString("USUARIO_CREA"));
                permiso.setUsuario_mod(rs.getString("USUARIO_MOD"));          
                permiso.setActivo(rs.getInt("ACTIVO"));
                                                  
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return permiso;
    }

    @Override
    public boolean insertar(ModelPermiso permiso) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO PERMISO (ID_PERMISO, ID_MODULO, ID_ROL, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, ACTIVO) "
                + "VALUES ( (SELECT ISNULL(MAX(ID_PERMISO),0) + 1 FROM PERMISO), " +                   
                 "'" + permiso.getId_modulo()+ "', " +
                 "'" + permiso.getId_rol()+ "', " +                
                "'" + permiso.getFecha_crea()+ "', " +
                "'" + permiso.getFecha_mod()+ "', " +
                "'" + permiso.getUsuario_crea()+ "', " +
                "'" + permiso.getUsuario_mod()+ "', " +
                "'" + permiso.getActivo()+ "'" +              
                  ")";
        System.out.println("Insertar permiso: " + strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelPermiso permiso) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE PERMISO "
                + "SET  " +                   
                "ID_MODULO = '" + permiso.getId_modulo()+ "', " +
                "ID_ROL = '" + permiso.getId_rol()+ "', " +
                "FECHA_CREA = '" + permiso.getFecha_crea()+ "', " +
                "FECHA_MOD = '" + permiso.getFecha_mod()+ "', " +
                "USUARIO_CREA = '" + permiso.getUsuario_crea()+ "', " +
                "USUARIO_MOD = '" + permiso.getUsuario_mod()+ "', " +              
                "ACTIVO = '" + permiso.getActivo()+ "'" +                 
                "WHERE ID_PERMISO = " + permiso.getId_permido();
        System.out.println("Permiso Modifica: " + strSql);
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelPermiso permiso) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE PERMISO WHERE ID_PERMISO = " + permiso.getId_permido();
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public List search(int idPermiso) {
        List<ModelPermiso> lista=new ArrayList<>();
        try {            
            strSql = "SELECT * FROM PERMISO WHERE ID_PERMISO LIKE '%"+ idPermiso +"%'";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelPermiso perm = new ModelPermiso();
                perm.setId_permido(rs.getInt("ID_PERMISO"));
                lista.add(idPermiso, perm);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lista;
    }
}
