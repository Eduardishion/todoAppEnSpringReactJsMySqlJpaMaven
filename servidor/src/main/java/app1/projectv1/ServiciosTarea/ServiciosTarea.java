/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1.projectv1.ServiciosTarea;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import app1.projectv1.EntidadesTarea.Tarea;
import app1.projectv1.EntidadesTarea.RepositorioTarea;
import java.util.ArrayList;

/**
 *
 * @author Caren
 */
@Service
public class ServiciosTarea implements InterfazServiciosTarea{
    
    @Autowired
    RepositorioTarea repoTarea;
    
    //servicios basicos CRUD "create- crear, read-leer, update-actualzar, delete-eliminar"
    
    //metodo para obtener todos los datos en la base de datos 
    @Override
    public List<Tarea> getAllTareas(){
        List<Tarea> Tareas = new ArrayList<>();
        repoTarea.findAll().forEach(tarea1 -> Tareas.add(tarea1));
        return Tareas;
    }
    
    //metodo para un unico registro por medio del identificador 
    @Override
    public Tarea getTareaById(long id){
        return repoTarea.findById(id).get();
    }
    
    //guardar un nuevo registro 
    @Override
    public void saveTarea(Tarea tarea){
        repoTarea.save(tarea);
    }
    
    //eliminar un registro por medio del id
    @Override
    public void deleteTarea(long id){
        repoTarea.deleteById(id);
    }
    
    //actualizar algun registro 
    @Override
    public void updateTarea(Tarea tarea, long id){
        repoTarea.save(tarea);
        //repoTarea.save(tarea);
    }
    
}


