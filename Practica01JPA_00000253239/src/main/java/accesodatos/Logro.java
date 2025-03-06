/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author multaslokas33
 */
@Entity
@Table(name="Logros")
public class Logro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "nombre",nullable=false)
    private String nombre;
    
    @Column(name= "puntos_obtenidos",nullable=false)
    private int puntos;
    
    @ManyToOne()
    @JoinColumn(name= "Videojuego_id",nullable=false)
    private Videojuego videojuego;

    public Logro() {
    }

    public Logro(Long id, String nombre, int puntos, Videojuego videojuego) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
        this.videojuego = videojuego;
    }

    public Logro(String nombre, int puntos, Videojuego videojuego) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.videojuego = videojuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logro{" + "id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + ", videojuego=" + videojuego.getNombre() + '}';
    }

}
