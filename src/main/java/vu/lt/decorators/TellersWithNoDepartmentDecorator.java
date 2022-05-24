package vu.lt.decorators;

import vu.lt.entities.Bank;
import vu.lt.services.teller.TellerService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class TellersWithNoDepartmentDecorator implements TellerService {

    @Inject
    @Delegate
    @Any
    TellerService tellerService;

    @Override
    public void createTeller(Bank bank, vu.lt.entities.Teller tellerToCreate) {
        if (tellerToCreate.getDepartment() == null) {
            tellerToCreate.setDepartment(53);
        }
        tellerService.createTeller(bank, tellerToCreate);
    }
}
