package vu.lt.persistence;

import vu.lt.entities.Account;
import vu.lt.entities.Client;
import vu.lt.entities.Teller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AccountDAO {

    @Inject
    private EntityManager em;

    public Account findOne(Integer id) {
        return em.find(Account.class, id);
    }

    public void persist(Account account){
        this.em.persist(account);
    }
}
