package vu.lt.persistence;

import vu.lt.entities.Teller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TellersDAO {

    @Inject
    private EntityManager em;

    public void persist(Teller teller){
        this.em.persist(teller);
    }

    public Teller findOne(Integer id){
        return em.find(Teller.class, id);
    }

    public Teller update(Teller teller){
        return em.merge(teller);
    }
}
