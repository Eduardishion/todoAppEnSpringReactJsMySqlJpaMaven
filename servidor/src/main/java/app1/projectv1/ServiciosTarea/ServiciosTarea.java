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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

/**
 *
 * @author Caren
 */
@Service
public class ServiciosTarea implements InterfazServiciosTarea{
    
    @Autowired
    RepositorioTarea repoTarea;

    @PersistenceContext
    EntityManager em;
    
    //servicios basicos CRUD "create- crear, read-leer, update-actualzar, delete-eliminar"
    
    //metodo para obtener todos los datos en la base de datos 
    @Override
    public List<Tarea> getAllTareas(){
        List<Tarea> Tareas = new ArrayList<>();
        repoTarea.findAll().forEach(tarea1 -> Tareas.add(tarea1));
        return Tareas;
    }

    @Override
    public List<Tarea> getAllTareasQuery() {
        //jpql
        String consulta = "SELECT c FROM Tarea c";
        Query query = em.createQuery(consulta);

        return query.getResultList();
    }

    @Override
    public List<Tarea> getAllTareasQueryOrder(long id) {
        //consulta donde solo se obtiene los tirulos de las tareas
        //gString consulta = "SELECT c.titulo FROM Tarea c WHERE c.descrip='MATE' ORDER BY c.titulo DESC";

        //joins t.category.id=1, se acceso al atributo de cateroria no a un campo de tarea
        //String consulta = "SELECT t.titulo FROM Tarea t WHERE t.category.id=1";

        //joins
        //String consulta = "SELECT t FROM Tarea e JOIN e.category t";

        //parametros dentro de query con cancatenacion
        //String consulta = "SELECT c.titulo FROM Tarea c WHERE c.id="+id;

        //consulta con set parametros
        String consulta = "SELECT c.titulo FROM Tarea c WHERE c.id=:identidicador";
        Query query = em.createQuery(consulta);
        query.setParameter("identidicador",id);

        return query.getResultList();
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
        //repoTarea.save(tare
    }
    
}


