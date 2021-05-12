package app1.projectv1.Zmodelos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


//para poder hacer otro tipo de cnsultas mas complejas 
//mediante un queryyy
@RepositoryRestResource
public interface repositorioAuto extends CrudRepository <Auto, Long>{
    //consultar datos por color
    List<Auto> findByColor(@Param("color") String color);
    
    //consultar datos por campo 
    
    List<Auto> findByYear(@Param("year") String year);
    
 
}