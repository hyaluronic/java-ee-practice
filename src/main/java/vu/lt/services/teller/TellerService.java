package vu.lt.services.teller;

import vu.lt.entities.Bank;
import vu.lt.persistence.TellersDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TellerService implements Teller {

    @Inject
    private TellersDAO tellersDAO;

    @Override
    public void createTeller(Bank bank, vu.lt.entities.Teller tellerToCreate) {
        tellerToCreate.setBank(bank);
        tellersDAO.persist(tellerToCreate);
    }
}
