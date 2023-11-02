package apitiendavideo.apitiendavideo.entidades;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tecnologia")
public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tecnologia")
    @GenericGenerator(name = "secuencia_tecnologia", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    public Tecnologia() {
    }

    public Tecnologia(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}