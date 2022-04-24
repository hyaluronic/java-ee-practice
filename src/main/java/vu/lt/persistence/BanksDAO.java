package vu.lt.persistence;

import vu.lt.entities.Bank;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BanksDAO {

    @Inject
    private EntityManager em;

    public List<Bank> loadAll() {
        return em.createNamedQuery("Bank.findAll", Bank.class).getResultList();
    }

    public void persist(Bank bank){
        this.em.persist(bank);
    }

    public Bank findOne(Integer id) {
        return em.find(Bank.class, id);
    }
}
