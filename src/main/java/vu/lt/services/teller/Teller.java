package vu.lt.services.teller;

import vu.lt.entities.Bank;

public interface Teller {
    void createTeller(Bank bank, vu.lt.entities.Teller tellerToCreate);
}
