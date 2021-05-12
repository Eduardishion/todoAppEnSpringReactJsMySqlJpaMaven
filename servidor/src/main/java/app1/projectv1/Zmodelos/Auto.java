package app1.projectv1.Zmodelos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Auto {
    //          !      Auto        !             !
    //!---------+------------------+-------------!
    //!  PK     !     id           !    long     !
    //!         !   brand          !    String   !
    //!         !   model          !    String   !
    //!         !   color          !    String   !
    //!         ! registrerNumber  !    String   !
    //!         !   year           !    int      !
    //!         !   price          !    int      !
    //!  FK     !  idPropietario   !    long     /
    
    //generacion de primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 
    
    //generando ptros atributos de la entidad 
    private String brand, model, color, registrerNumber;
    private int year, price; 
   
    //-------------------- relacion muchos a uno  ------------------------------
        //deficinicion de la relacion con la  tabla Propietario de muchos a uno 
        @ManyToOne(fetch = FetchType.LAZY)

        //para crear el campo foreign key para asociar la otra labla mediante su id 
        @JoinColumn(name = "FKidPropietario")

        //creacion tabla a la cual esta asiciada
        private Propietario propietario;
    //-------------------- relacion muchos a uno  ------------------------------
    


    //----------------ejemplo de relacion de muchos a muchos -------------------
        
        
    //----------------ejemplo de relacion de muchos a muchos -------------------
        
    
        
    

    public Auto(){

    }

    public Auto(String brand,String model,String color, String registrerNumber, int year, int price, Propietario propietario){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrerNumber = registrerNumber;
        this.year = year;
        this.price = price;
        this.propietario = propietario;
        
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
   
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the registrerNumber
     */
    public String getRegistrerNumber() {
        return registrerNumber;
    }

    /**
     * @param registrerNumber the registrerNumber to set
     */
    public void setRegistrerNumber(String registrerNumber) {
        this.registrerNumber = registrerNumber;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    

    

}