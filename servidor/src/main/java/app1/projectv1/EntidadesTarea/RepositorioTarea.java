/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1.projectv1.EntidadesTarea;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Caren
 */

@RepositoryRestResource
public interface RepositorioTarea extends CrudRepository<Tarea,Long>{

    
}
