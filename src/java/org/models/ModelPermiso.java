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
public class ModelPermiso {
    private int id_permido;
    private int id_modulo;
    private int id_rol;
    private int fecha_crea;
    private int fecha_mod;
    private String usuario_crea;
    private String usuario_mod;
    private int activo;

    public ModelPermiso() {
    }

    public ModelPermiso(int id_permido, int id_modulo, int id_rol, int fecha_crea, int fecha_mod, String usuario_crea, String usuario_mod, int activo) {
        this.id_permido = id_permido;
        this.id_modulo = id_modulo;
        this.id_rol = id_rol;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
        this.usuario_crea = usuario_crea;
        this.usuario_mod = usuario_mod;
        this.activo = activo;
    }

    public int getId_permido() {
        return id_permido;
    }

    public void setId_permido(int id_permido) {
        this.id_permido = id_permido;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
}
