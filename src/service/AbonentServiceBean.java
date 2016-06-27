package service;

import models.AbonentsEntity;
import models.ServicesEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Vlad on 16.06.16.
 */
@Stateless(name = "AbonentServiceEJB")
@LocalBean
public class AbonentServiceBean {
    public AbonentServiceBean() {
    }
    @PersistenceContext(unitName = "Payment")
    private EntityManager em;

   public void addAbonent (AbonentsEntity ab, String serviceId ) {
       TypedQuery<ServicesEntity> sQuery = em.createNamedQuery("Services.findById", ServicesEntity.class);
       sQuery.setParameter("id", Integer.parseInt(serviceId));
       ServicesEntity s = sQuery.getSingleResult();
       ab.setServicesByServiceId(s);

        try {
            em.persist(ab);
            em.flush();
            addAbonentToService(ab, s);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addAbonentToService(AbonentsEntity ab, ServicesEntity se) {
        TypedQuery <AbonentsEntity> aQuery = em.createNamedQuery("Abonents.findById", AbonentsEntity.class);
        aQuery.setParameter("id", ab.getAbonentId());
        ab = aQuery.getSingleResult();

        Collection<AbonentsEntity> sColl = se.getAbonentsByServiceId();
        sColl.add(ab);
        se.setAbonentsByServiceId(sColl);
    }


}
