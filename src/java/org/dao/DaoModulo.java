/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.dao;

/**
 *
 * @author Usuario
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudModulo;
import org.models.ModelModulo;

public class DaoModulo implements CrudModulo {
    //Se crea un objeto publico del Cliente
    ModelModulo modulo = new ModelModulo();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    @Override  
    public List listar() {
        ArrayList<ModelModulo>lstModulo = new ArrayList<>();
         try {            
            strSql =/* "SELECT P.ID_MODULO, P.NOMBRE, P.DESCRIPCION, P.PATH, P.NIVEL, P.ORDEN, P.ID_MODULO_PADRE, P.FECHA_CREA, P.FECHA_MOD, P.USUARIO_CREA, P.USUARIO_MOD, P.ACTIVO," + 
                     "TP.ID_PERMISO CATEGORIA, CASE WHEN P.ACTIVO = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END DESCESTADO " +
                     "FROM	MODULO P " + 
                     "JOIN	PERMISO TP " +
                     "ON		P.FECHA_CREA = TP.FECHA_CREA " +
                     "ON		P.FECHA_MOD = TP.FECHA_MOD " +
                     "ON		P.USUARIO_CREA = TP.USUARIO_CREA " +
                     "ON		P.USUARIO_MOD = TP.USUARIO_MOD "*/
                    
                    "SELECT * FROM MODULO";
             System.out.println("Query Modulo: " + strSql);
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelModulo mod = new ModelModulo();
                mod.setId_modulo(rs.getInt("ID_MODULO"));
                mod.setNombre(rs.getString("NOMBRE"));
                mod.setDescripcion(rs.getString("DESCRIPCION"));
                mod.setPath(rs.getString("PATH"));
                mod.setNivel(rs.getInt("NIVEL"));
                mod.setOrden(rs.getInt("ORDEN"));
                mod.setId_modulo_padre(rs.getInt("ID_MODULO_PADRE"));
                mod.setFecha_crea(rs.getInt("FECHA_CREA"));
                mod.setFecha_mod(rs.getInt("FECHA_MOD"));
                mod.setUsuario_crea(rs.getString("USUARIO_CREA"));
                mod.setUsuario_mod(rs.getString("USUARIO_MOD"));
                mod.setActivo(rs.getInt("ACTIVO"));
                
                lstModulo.add(mod);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstModulo;
    }

    @Override
    public ModelModulo list(int id) {
         ModelModulo modulo = new ModelModulo();
         try {            
            strSql = "SELECT * FROM MODULO WHERE ID_MODULO =  " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                
                modulo.setId_modulo(rs.getInt("ID_MODULO"));
                modulo.setNombre(rs.getString("NOMBRE"));
                modulo.setDescripcion(rs.getString("DESCRIPCION"));
                modulo.setPath(rs.getString("PATH"));
                modulo.setNivel(rs.getInt("NIVEL"));
                modulo.setOrden(rs.getInt("ORDEN"));
                modulo.setId_modulo_padre(rs.getInt("ID_MODULO_PADRE"));
                modulo.setFecha_crea(rs.getInt("FECHA_CREA"));
                modulo.setFecha_mod(rs.getInt("FECHA_MOD"));
                modulo.setUsuario_crea(rs.getString("USUARIO_CREA"));
                modulo.setUsuario_mod(rs.getString("USUARIO_MOD"));
                modulo.setActivo(rs.getInt("ACTIVO"));                             
                
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
         return modulo;
    }

    @Override
    public boolean insertar(ModelModulo modulo) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO MODULO (ID_MODULO, NOMBRE, DESCRIPCION, PATH, NIVEL, ORDEN, ID_MODULO_PADRE, FECHA_CREA, FECHA_MOD, USUARIO_CREA, USUARIO_MOD, ACTIVO) "
                + "VALUES ( (SELECT ISNULL(MAX(ID_MODULO),0) + 1 FROM MODULO), " +                   
                 "'" + modulo.getNombre()+ "', " +                 
                "'" + modulo.getDescripcion()+ "', " +       
                 "'" + modulo.getPath() + "', " +
                "'" + modulo.getNivel() + "', " +
                "'" + modulo.getOrden() + "', " +
                "'" + modulo.getId_modulo_padre() + "', " +
                "'" + modulo.getFecha_crea() + "', " +
                "'" + modulo.getFecha_mod() + "', " +
                "'" + modulo.getUsuario_crea() + "', " +
                "'" + modulo.getUsuario_mod() + "', " +
                 "'" + modulo.getActivo()+ "'" +                 
                  ")";
        System.out.println("Insertar modulo: " + strSql);
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
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelModulo modulo) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE MODULO "
                + "SET  " +  
                "NOMBRE = '" + modulo.getNombre()+ "', " +
                "DESCRIPCION = '" + modulo.getDescripcion()+ "', " +                 
                "PATH = '" + modulo.getPath()+ "', " +       
                "NIVEL = '" + modulo.getNivel() + "', " +
                "ORDEN = '" + modulo.getOrden() + "', " +
                "ID_MODULO_PADRE = '" + modulo.getId_modulo_padre() + "', " +
                "FECHA_CREA = '" + modulo.getFecha_crea() + "', " +
                "FECHA_MOD = '" + modulo.getFecha_mod() + "', " +
                "USUARIO_CREA = '" + modulo.getUsuario_crea() + "', " +
                "USUARIO_MOD = '" + modulo.getUsuario_mod() + "', " +
                "ACTIVO = '" + modulo.getActivo()+ " '" +                 
                "WHERE ID_MODULO = " + modulo.getId_modulo();
        System.out.println("Modulo Modifica: " + strSql);
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
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModelModulo modulo) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE MODULO WHERE ID_MODULO = " + modulo.getId_modulo();
        
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
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public List search(int id_modulo) {
        ArrayList<ModelModulo>lista = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM MODULO WHERE ID_MODULO LIKE '%"+ id_modulo +"%'";
             System.out.println("Query Modulo: " + strSql);
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelModulo modu = new ModelModulo();
                modu.setId_modulo(rs.getInt("ID_MODULO"));
                lista.add(modu);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lista;
    }
}
