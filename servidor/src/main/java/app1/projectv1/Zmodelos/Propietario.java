/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1.projectv1.Zmodelos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

 

/**
 *
 * @author Caren
 */
@Entity
public class Propietario {
    
    //          !    Propietario    !
    //!---------+-------------------+-------------!
    //!  PK     ! idPropietario     !    long     !
    //!         !   firstname       !    String   !
    //!         !   lastname        !    String   !
 
    
    
    //generacion de primary key 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPropietario;
   
    //generando ptros atributos de la entidad 
    private String firstname, lastname;
   
    
    //-------------------- relacion uno a muchos ------------------------------ 
    //deficinicion de la relacion con la  tabla entidadAutoMovil de uno a muchos
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "propietario" )
        
        //para detener iteracion infinita al hacer peticion por metodo get 
        //@JsonIgnore
        //cuando se tienen leaciones entre tablas LAZY
        @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
        //creacion tabla a la cual esta asiciada
        private List<Auto> carros;  
    //-------------------- relacion uno a muchos ------------------------------ 
        
        
    

    public Propietario() {
    }

    public Propietario(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
     public List<Auto> getCarros() {
        return carros;
    }

    public void setCarros(List<Auto> carros) {
        this.carros = carros;
    }
    
}
