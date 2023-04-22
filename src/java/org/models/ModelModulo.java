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
public class ModelModulo {
    private int id_modulo;
    private String nombre;
    private String descripcion;
    private String path;
    private int nivel;
    private int orden;
    private int id_modulo_padre;
    private int fecha_crea;
    private int fecha_mod;
    private String usuario_crea;
    private String usuario_mod;
    private int activo;

    public ModelModulo() {
    }

    /*public ModelModulo(int id_modulo, String nombre, String descripcion, String path, int nivel, int orden, int id_modulo_padre, int fecha_crea, int fecha_mod, String usuario_crea, String usuario_mod, Boolean activo) {
        this.id_modulo = id_modulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.path = path;
        this.nivel = nivel;
        this.orden = orden;
        this.id_modulo_padre = id_modulo_padre;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
        this.usuario_crea = usuario_crea;
        this.usuario_mod = usuario_mod;
        this.activo = activo;
    }*/

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getId_modulo_padre() {
        return id_modulo_padre;
    }

    public void setId_modulo_padre(int id_modulo_padre) {
        this.id_modulo_padre = id_modulo_padre;
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
