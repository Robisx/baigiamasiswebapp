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
import lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vieta;

/**
 *
 * @author User1
 */
public class VietaManager {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Baigiamasis_WebAPPPU");

    public List<Vieta> getAllVieta() {
        List<Vieta> list = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createNamedQuery("Vieta.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
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

    public void addVieta(Vieta vieta) {
        persist(vieta);
    }
}
