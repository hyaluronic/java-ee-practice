package vu.lt.services.account;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class SecureAccountNumberValidator extends AccountNumberValidator {

    @Override
    public void validate(String accountNumber) {
        if (accountNumber == null || !accountNumber.matches("^[\\d]+$")) {
            throw new IllegalArgumentException();
        }
    }
}
