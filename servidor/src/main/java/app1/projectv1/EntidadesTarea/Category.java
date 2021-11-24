package app1.projectv1.EntidadesTarea;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name = "Categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    //lacion con tarea de uno a muchos
    @OneToMany(mappedBy = "category")
    private List<Tarea> Tareas;



    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
