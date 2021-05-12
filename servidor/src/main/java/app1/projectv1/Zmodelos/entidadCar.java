package app1.projectv1.Zmodelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 * InnerentidadCar
 */
@Entity
public class entidadCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 
    private int edad;
    private String nombre;

    public entidadCar() {
    }

    public entidadCar(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

}