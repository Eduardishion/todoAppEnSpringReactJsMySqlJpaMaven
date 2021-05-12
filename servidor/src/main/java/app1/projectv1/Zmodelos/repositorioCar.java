package app1.projectv1.Zmodelos;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

public interface repositorioCar extends CrudRepository <entidadCar, Long>{
//public interface repositorioCar extends PagingAndSortingRepository <entidadCar, Long>{    
    
    //---------------aplicacion de querys a la base de datos ----------------------------------
    
    // obtener datos por el nombre
    List<entidadCar> findByNombre(String nombre);
  
    //obtener dastos por la edad 
    List<entidadCar> findByEdad(String edad);

    //obtener datos con varios campos con prefijo and 
    List<entidadCar> findByNombreAndEdad(String nombre, int edad);
    
    //obtener datos con varios campos con prefijo or  
    //List<entidadCar> findByNombreeOrEdad(String nombre, int edad);
    
    //ordenar datos con OrderBy
    List<entidadCar> findBynombreOrderByEdadAsc(String nombre);
    
    //obtener datos usando sql y y anotacion @query
    //@Query("SELECT * FROM ENTIDAD_CAR ")
    //List<entidadCar> findBynombre(String nombre);
    
}