/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelPermiso;

/**
 *
 * @author Usuario
 */
public interface CrudPermiso {
    public List listar();
    public ModelPermiso list (int id_permiso);
    public boolean insertar(ModelPermiso permiso);
    public boolean modificar(ModelPermiso permiso);
    public boolean eliminar(ModelPermiso permiso);
    public List search(int idPermiso);
}
