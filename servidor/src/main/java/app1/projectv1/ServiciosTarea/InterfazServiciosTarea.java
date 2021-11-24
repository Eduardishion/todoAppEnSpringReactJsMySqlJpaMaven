/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1.projectv1.ServiciosTarea;

/**
 *
 * @author Caren
 */
import java.util.List;
import java.util.Optional;
import app1.projectv1.EntidadesTarea.Tarea;

public interface InterfazServiciosTarea {
    public List<Tarea> getAllTareas();
    public List<Tarea> getAllTareasQuery();
    public List<Tarea> getAllTareasQueryOrder(long id);
    public Tarea getTareaById(long id);
    public void saveTarea(Tarea tarea);
    public void deleteTarea(long id);
    public void updateTarea(Tarea tarea, long id);
}
