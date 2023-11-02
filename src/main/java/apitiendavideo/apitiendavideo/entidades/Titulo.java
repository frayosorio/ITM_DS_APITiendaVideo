package apitiendavideo.apitiendavideo.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "titulo")
public class Titulo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_titulo")
    @GenericGenerator(name = "secuencia_titulo", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "nombre", length = 100, unique = true)
    private String nombre;

    @Column(name = "año")
    private int año;

    @Column(name = "protagonistas", length = 1000)
    private String protagonistas;

    @Column(name = "productor", length = 100)
    private String productor;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "idempresa", referencedColumnName = "id")
    private Empresa empresa;

    public Titulo() {
    }

    public Titulo(long id, String nombre, int año, String protagonistas, String productor, String director,
            double precio, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.protagonistas = protagonistas;
        this.productor = productor;
        this.director = director;
        this.precio = precio;
        this.empresa = empresa;
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(String protagonistas) {
        this.protagonistas = protagonistas;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}
