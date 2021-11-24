package app1.projectv1.EntidadesTarea;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "Images")
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="tarea_id")
    private  Tarea tarea;


    public Image() {

    }

    public Image(Long id, String name) {
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