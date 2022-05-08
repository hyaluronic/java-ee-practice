package vu.lt.services.account;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountNumberValidator {

    public void validate(String accountNumber) {
        if (accountNumber == null || !accountNumber.matches("^[\\w]+$")){
            throw new IllegalArgumentException();
        }
    }
}
