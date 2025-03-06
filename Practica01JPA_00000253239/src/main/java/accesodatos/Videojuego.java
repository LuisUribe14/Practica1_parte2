/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author multaslokas33
 */
@Entity
@Table(name= "Videojuego")
public class Videojuego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "nombre",nullable=false, length = 150)
    private String nombre;
    
    @Column(name= "puntaje")
    private int puntaje;
    
    @Column(name= "desarolladora", nullable=false, length = 100)
    private String desarolladora;
    
    @ManyToMany(mappedBy = "videojuegos")
    private List<Jugador> jugadores = new ArrayList<>();

    @OneToMany(mappedBy="videojuego", cascade = CascadeType.ALL)
    private List<Logro> logros = new ArrayList<>();
    
    public Videojuego() {
    }

    public Videojuego(Long id, String nombre, int puntaje, String desarolladora) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.desarolladora = desarolladora;
    }

    public Videojuego(String nombre, int puntaje, String desarolladora) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.desarolladora = desarolladora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getDesarolladora() {
        return desarolladora;
    }

    public void setDesarolladora(String desarolladora) {
        this.desarolladora = desarolladora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Logro> getLogros() {
        return logros;
    }

    public void setLogros(List<Logro> logros) {
        this.logros = logros;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public void addLogro(Logro logro) {
        logros.add(logro);
        logro.setVideojuego(this);
    }

    public void removeLogro(Logro logro) {
        logros.remove(logro);
        logro.setVideojuego(null);
    }
    
    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
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
        if (!(object instanceof Videojuego)) {
            return false;
        }
        Videojuego other = (Videojuego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return "Videojuego{" + "id=" + id + ", nombre=" + nombre + ", puntaje=" + puntaje + ", desarrolladora=" + desarolladora + '}';
    }
    
}
