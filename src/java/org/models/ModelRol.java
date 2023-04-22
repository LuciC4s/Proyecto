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
public class ModelRol {
    private int id_rol;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private String usuario_crea;
    private String usuario_mod;
    private int fecha_crea;
    private int fecha_mod;

    public ModelRol() {
    }

    public ModelRol(int id_rol, String nombre, String descripcion, Boolean activo, String usuario_crea, String usuario_mod, int fecha_crea, int fecha_mod) {
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.usuario_crea = usuario_crea;
        this.usuario_mod = usuario_mod;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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

    public int getFecha_crea() {
        return fecha_crea;
    }

    public void setFecha_crea(int fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    public int getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(int fecha_mod) {
        this.fecha_mod = fecha_mod;
    }
    
    
}
