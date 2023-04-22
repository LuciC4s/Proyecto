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
import org.interfaces.CrudUsuario;
import org.models.ModelUsuario;

public class DaoUsuario implements CrudUsuario{
    ModelUsuario usuario = new ModelUsuario();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;    
    @Override
    public List listar() {
        ArrayList<ModelUsuario> lstUsuario = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM USUARIO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelUsuario usu = new ModelUsuario();
                usu.setId_usuario(rs.getInt("ID_USUARIO"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setUsuario(rs.getString("USUARIO"));
                usu.setPassword(rs.getString("PASSWORD"));
                usu.setId_rol(rs.getInt("ID_ROL"));
                usu.setFecha_crea(rs.getInt("FECHA_CREA"));    
                usu.setUsuario_crea(rs.getString("USUARIO_CREA"));
                usu.setUsuario_mod(rs.getString("USUARIO_MOD"));
                usu.setCodigo(rs.getInt("CODIGO"));
                usu.setFecha_mod(rs.getInt("FECHA_MOD"));
                usu.setActivo(rs.getBoolean("ACTIVO"));
                lstUsuario.add(usu);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstUsuario;
    }

    @Override
    public ModelUsuario list(int id) {
        ModelUsuario usuario = new ModelUsuario();
        try {            
            strSql = "SELECT * FROM USUARIO WHERE ID_USUARIO =  " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                
                usuario.setId_usuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido(rs.getString("APELLIDO"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setId_rol(rs.getInt("ID_ROL"));
                usuario.setFecha_crea(rs.getInt("FECHA_CREA"));
                usuario.setUsuario_crea(rs.getString("USUARIO_CREA"));
                usuario.setUsuario_mod(rs.getString("USUARIO_MOD"));
                usuario.setCodigo(rs.getInt("CODIGO"));
                usuario.setFecha_mod(rs.getInt("FECHA_MOD"));
                usuario.setActivo(rs.getBoolean("ACTIVO"));
                                                  
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return usuario;
    }

    @Override
    public boolean insertar(ModelUsuario usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO USUARIO (ID_USUARIO, NOMBRE, APELLIDO, USUARIO, PASSWORD, ID_ROL, FECHA_CREA, USUARIO_CREA, USUARIO_MOD, CODIGO, FECHA_MOD, ACTIVO) "
                + "VALUES ( (SELECT ISNULL(MAX(ID_USUARIO),0) + 1 FROM USUARIO), " +                   
                 "'" + usuario.getNombre()+ "', " +
                 "'" + usuario.getApellido()+ "', " +                
                "'" + usuario.getUsuario()+ "', " +
                "'" + usuario.getPassword()+ "', " +
                "'" + usuario.getId_rol()+ "', " +
                "'" + usuario.getFecha_crea()+ "', " +
                "'" + usuario.getUsuario_crea()+ "', " +
                "'" + usuario.getUsuario_mod()+ "', " +
                "'" + usuario.getCodigo()+ "', " +
                "'" + usuario.getFecha_mod()+ "', " +
                "'" + usuario.getActivo()+ "'" +              
                  ")";
        System.out.println("Insertar usuario: " + strSql);
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
    public boolean modificar(ModelUsuario usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE USUARIO "
                + "SET  " +                   
                "NOMBRE = '" + usuario.getNombre()+ "', " +
                "APELLIDO = '" + usuario.getApellido()+ "', " +
                "USUARIO = '" + usuario.getUsuario()+ "', " +       
                "PASSWORD = '" + usuario.getPassword()+ "', " +
                "ID_ROL = '" + usuario.getId_rol()+ "', " +
                "FECHA_CREA = '" + usuario.getFecha_crea()+ "', " +
                "USUARIO_CREA = '" + usuario.getUsuario_crea()+ "', " +
                "USUARIO_MOD = '" + usuario.getUsuario_mod()+ "', " +
                "CODIGO = '" + usuario.getCodigo()+ "', " +
                "FECHA_MOD = '" + usuario.getFecha_mod()+ "', " +
                "ACTIVO = '" + usuario.getActivo()+ "'" +                 
                "WHERE ID_USUARIO = " + usuario.getId_usuario();
        System.out.println("Usuario Modifica: " + strSql);
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
    public boolean eliminar(ModelUsuario usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE USUARIO WHERE ID_USUARIO = " + usuario.getId_usuario();
        
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
    public List search(int idUsuario) {
        List<ModelUsuario> lista=new ArrayList<>();
        try {            
            strSql = "SELECT * FROM USUARIO WHERE ID_USUARIO LIKE '%"+ idUsuario +"%'";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelUsuario usua = new ModelUsuario();
                usua.setId_usuario(rs.getInt("ID_USUARIO"));
                lista.add(idUsuario, usua);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lista;
    }
}
