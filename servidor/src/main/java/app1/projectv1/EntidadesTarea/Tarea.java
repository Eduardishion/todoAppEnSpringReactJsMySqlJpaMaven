/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1.projectv1.EntidadesTarea;

import javax.persistence.*;
import java.util.List;
import app1.projectv1.EntidadesTarea.Category;


@Table(name = "Tareas")
@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long _id; 
    
    private String titulo;
    private String descrip;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "tarea")
    private List<Image> images;


    public Tarea() {
    }

    public Tarea(String titulo, String descrip) {
        this.titulo = titulo;
        this.descrip = descrip;
    }
    

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    
    
    
    
}
