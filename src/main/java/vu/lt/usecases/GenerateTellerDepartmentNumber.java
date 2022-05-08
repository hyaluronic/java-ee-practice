package vu.lt.usecases;

import vu.lt.interceptors.LoggedInvocation;
import vu.lt.services.department.DepartmentNumberGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateTellerDepartmentNumber implements Serializable {
    @Inject
    DepartmentNumberGenerator departmentNumberGenerator;

    private CompletableFuture<Integer> departmentNumberGenerationTask = null;

    @LoggedInvocation
    public String generateNewDepartmentNumber() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        departmentNumberGenerationTask = CompletableFuture.supplyAsync(() -> departmentNumberGenerator.generateDepartmentNumber());

        return  "/tellerDetails.xhtml?faces-redirect=true&tellerId=" + requestParameters.get("tellerId");
    }

    public boolean isDepartmentGenerationRunning() {
        return departmentNumberGenerationTask != null && !departmentNumberGenerationTask.isDone();
    }

    public String getDepartmentGenerationStatus() throws ExecutionException, InterruptedException {
        if (departmentNumberGenerationTask == null) {
            return null;
        } else if (isDepartmentGenerationRunning()) {
            return "Department generation in progress";
        }
        return "Suggested department number: " + departmentNumberGenerationTask.get();
    }
}