package vu.lt.persistence;

import vu.lt.entities.Teller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class TellersDAO {

    @Inject
    private EntityManager em;

    public void persist(Teller teller) {
        this.em.persist(teller);
    }

    public Teller findOne(Integer id) {
        return em.find(Teller.class, id);
    }

    public void lock(Teller teller, LockModeType lockMode) {
        em.lock(teller, lockMode);
    }

    public void refresh(Teller teller) {
        em.refresh(teller);
    }

    public Teller update(Teller teller) {
        return em.merge(teller);
    }
}
