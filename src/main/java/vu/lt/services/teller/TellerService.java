package vu.lt.services.teller;

import vu.lt.entities.Bank;

public interface TellerService {

    void createTeller(Bank bank, vu.lt.entities.Teller tellerToCreate);
}
