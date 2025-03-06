/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practica01jpa_00000253239;

import accesodatos.Direcciones;
import accesodatos.Jugador;
import java.time.LocalDate;
import java.time.Month;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author multaslokas33
 */
public class Practica01JPA_00000253239 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

//        LocalDate fechaNacimiento = LocalDate.of(2005, Month.DECEMBER, 24);
//        Jugador jugador = new Jugador("Crit", "Femenino", fechaNacimiento);
//        
//        em.persist(jugador);
//        
//        em.getTransaction().commit();
//        
//        em.close();
//        emf.close();
//            Jugador jugadorActualizado = em.find(Jugador.class, 1L);
//
//            if (jugadorActualizado != null) {
//                jugadorActualizado.setNombre("Daniel");
//                jugadorActualizado.setSexo("Masculino");
//                jugadorActualizado.setFechaNacimiento(LocalDate.of(2005, 11, 20));
//            Jugador nuevoJugador = new Jugador("Katia", "Masculino", LocalDate.of(2004, 4, 17));
//
//            // Intentamos insertar con merge()
//            Jugador jugadorMerge = em.merge(nuevoJugador);
//            em.getTransaction().commit();
//            Jugador jugadorEliminado = em.find(Jugador.class, 1L);
//
//            if (jugadorEliminado != null) {
//                em.remove(jugadorEliminado);
//                em.getTransaction().commit();
//
//                System.out.println("Jugador eliminado: " + jugadorEliminado);
//            } else {
//                System.out.println("Jugador no encontrado");
//                em.getTransaction().rollback();
//            }
            Direcciones direccion = new Direcciones("Tecat3", 147, "Centro");
            Jugador jugador = new Jugador("Crit", "Femenino", LocalDate.of(2005, 12, 24), direccion);

            em.persist(jugador);

            em.getTransaction().commit();
            System.out.println("Jugador guardado con dirección");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
