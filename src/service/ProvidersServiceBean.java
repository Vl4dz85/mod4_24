package service;

import models.ProvidersEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Vlad on 23.06.16.
 */
@Stateless(name = "ProvidersServiceEJB")
@LocalBean
public class ProvidersServiceBean {
    public ProvidersServiceBean() {
    }

    @PersistenceContext(unitName = "Payment")
    private EntityManager em;

   public void addProvider (ProvidersEntity pr) {
        try {
            em.persist(pr);
            em.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
