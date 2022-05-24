package vu.lt.services.teller;

import vu.lt.entities.Bank;
import vu.lt.entities.Teller;
import vu.lt.persistence.TellersDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TellerServiceImpl implements TellerService {

    @Inject
    private TellersDAO tellersDAO;

    @Override
    public void createTeller(Bank bank, Teller tellerToCreate) {
        tellerToCreate.setBank(bank);
        tellersDAO.persist(tellerToCreate);
    }
}
