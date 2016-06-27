package service;

import models.ProvidersEntity;
import models.ServicesEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Vlad on 19.06.16.
 */
@Stateless(name = "ServiceServiceEJB")
@LocalBean
public class ServiceServiceBean {
    public ServiceServiceBean() {
    }
    @PersistenceContext(unitName = "Payment")
    private EntityManager em;

    public void addService (ServicesEntity se, String providerId) {
        TypedQuery<ProvidersEntity> pQuery = em.createNamedQuery("Provider.findById", ProvidersEntity.class);

        pQuery.setParameter("id", Integer.parseInt(providerId));

        ProvidersEntity p = pQuery.getSingleResult();

        se.setProvidersByProviderId(p);
        try {
            em.persist(se);
            em.flush();
            addServiceToProvider(se, p);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addServiceToProvider(ServicesEntity se, ProvidersEntity pe) {


        TypedQuery<ServicesEntity> sQuery = em.createNamedQuery("Services.findById", ServicesEntity.class);

        sQuery.setParameter("id", se.getServiceId());

        se = sQuery.getSingleResult();


        Collection<ServicesEntity> sColl = pe.getServicesesByProviderId();

        sColl.add(se);

        pe.setServicesesByProviderId(sColl);


    }

    public Collection<ServicesEntity> getServices() {

        TypedQuery<ServicesEntity> query = em.createQuery("SELECT s FROM ServicesEntity s", ServicesEntity.class);
        Collection<ServicesEntity> results = query.getResultList();
        return results;

    }

}
