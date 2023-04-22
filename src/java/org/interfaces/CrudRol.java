/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelRol;

/**
 *
 * @author Usuario
 */
public interface CrudRol {
    //public List listar();
    //public ModelRol list (int id_rol);
    //public boolean insertar(ModelRol rol);

    public List listar();

    public ModelRol list(int id_rol);

    public boolean insertar(ModelRol rol);

    public boolean modificar(ModelRol rol);

    public boolean eliminar(ModelRol rol);

    public List search(int id_rol);

}
