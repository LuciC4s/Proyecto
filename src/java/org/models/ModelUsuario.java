/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author Usuario
 */
public class ModelUsuario {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String Usuario;
    private String password;
    private int id_rol;
    private int fecha_crea;
    private int activo;
    private int fecha_mod;
    private String usuario_crea;
    private String usuario_mod;
    private int codigo;

    public ModelUsuario() {
    }

    public ModelUsuario(int id_usuario, String nombre, String apellido, String Usuario, String password, int id_rol, int fecha_crea, int activo, int fecha_mod, String usuario_crea, String usuario_mod, int codigo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Usuario = Usuario;
        this.password = password;
        this.id_rol = id_rol;
        this.fecha_crea = fecha_crea;
        this.activo = activo;
        this.fecha_mod = fecha_mod;
        this.usuario_crea = usuario_crea;
        this.usuario_mod = usuario_mod;
        this.codigo = codigo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getFecha_crea() {
        return fecha_crea;
    }

    public void setFecha_crea(int fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(int fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public String getUsuario_crea() {
        return usuario_crea;
    }

    public void setUsuario_crea(String usuario_crea) {
        this.usuario_crea = usuario_crea;
    }

    public String getUsuario_mod() {
        return usuario_mod;
    }

    public void setUsuario_mod(String usuario_mod) {
        this.usuario_mod = usuario_mod;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
