/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Album;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conector {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Conector() {
    }

    private void Sesion() {
        emf = Persistence.createEntityManagerFactory("Musica");
        em = emf.createEntityManager();
    }

    private void CerrarSesion() {
        em.close();
    }

    public boolean Insertar(Album al) {
        boolean result = false;
        Sesion();

        try {
            em.getTransaction().begin();
            em.persist(al);
            em.getTransaction().commit();
            result = true;
        } catch (org.hibernate.DuplicateMappingException e) {
            JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA" + e.getMessage(), "ERROR", 0);
            em.getTransaction().rollback();
            
        }

        CerrarSesion();
        return result;
    }

    public boolean Actualizar(Album al) {
        boolean result = false;
        Sesion();

        try {
            em.getTransaction().begin();
            em.merge(al);
            em.getTransaction().commit();
            result = true;
        } catch (org.hibernate.HibernateException e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ACTUALIZAR", "ERROR", 0);
        }

        CerrarSesion();
        return result;
    }

    public boolean Borrar(Album al) {
        boolean result = false;
        Sesion();

        try {
            em.getTransaction().begin();
            em.remove(em.merge(al));
            em.getTransaction().commit();
            result = true;
        } catch (org.hibernate.HibernateException e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "NO SE HA PODIDO BORRAR", "ERROR", 0);
        }

        CerrarSesion();
        return result;
    }

    public List lanzarConsulta(String consulta) {
        List resultList = null;

        Sesion();

        try {
            Query query = em.createQuery(consulta);

            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CerrarSesion();
        }
        return resultList;
    }

    public List cargarAlbumes() {
        return lanzarConsulta("FROM Album");
    }

    public Album getAlbum(int id) {
        List<Album> albumes = lanzarConsulta("FROM Album WHERE id = " + id);
        return albumes.get(0);
    }
}
