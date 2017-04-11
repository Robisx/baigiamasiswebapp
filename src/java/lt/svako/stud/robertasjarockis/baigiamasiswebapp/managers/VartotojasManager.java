/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vartotojas;

/**
 *
 * @author User1
 */
public class VartotojasManager {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Baigiamasis_WebAPPPU");

    public List<Vartotojas> getAllVartotojai(){
    List<Vartotojas> list = new ArrayList<>();
    EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createNamedQuery("Vartotojas.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
}
    public List<Vartotojas> getVartotojas(String username){
    List<Vartotojas> list = new ArrayList<>();
    EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createNamedQuery("Vartotojas.findByVartotojopav").setParameter("vartotojopav", username).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
}
    public void createVartotojas(Vartotojas vartotojas){
        persist(vartotojas);
    }
    
    private void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
