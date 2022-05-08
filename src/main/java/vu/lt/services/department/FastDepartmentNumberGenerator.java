package vu.lt.services.department;

import vu.lt.services.department.DepartmentNumberGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@Alternative
@ApplicationScoped
public class FastDepartmentNumberGenerator implements Serializable, DepartmentNumberGenerator {

    public Integer generateDepartmentNumber() {
        return new Random().nextInt(100);
    }
}