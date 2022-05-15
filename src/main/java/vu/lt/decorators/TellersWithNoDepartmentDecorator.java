package vu.lt.decorators;

import vu.lt.entities.Bank;
import vu.lt.services.teller.Teller;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class TellersWithNoDepartmentDecorator implements Teller {

    @Inject
    @Delegate
    @Any
    Teller teller;

    @Override
    public void createTeller(Bank bank, vu.lt.entities.Teller tellerToCreate) {
        if (tellerToCreate.getDepartment() == null) {
            tellerToCreate.setDepartment(53);
        }
        teller.createTeller(bank, tellerToCreate);
    }
}
