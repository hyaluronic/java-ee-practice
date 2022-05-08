package vu.lt.services.department;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class StandardDepartmentNumberGenerator implements Serializable, DepartmentNumberGenerator {

    public Integer generateDepartmentNumber() {
        try {
            Thread.sleep(5000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer generatedDepartmentNumber = new Random().nextInt(100);
        return generatedDepartmentNumber;
    }
}