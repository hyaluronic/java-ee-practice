package vu.lt.usecases;


import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Teller;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.TellersDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateTellerDetails implements Serializable {

    private Teller teller;

    @Inject
    private TellersDAO tellersDAO;

    private String overrideMessage = "";

    @PostConstruct
    private void init() {
        System.out.println("updateTellerClients INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer tellerId = Integer.parseInt(requestParameters.get("tellerId"));
        this.overrideMessage = requestParameters.get("overrideMessage") != null ? requestParameters.get("overrideMessage") : "";
        this.teller = tellersDAO.findOne(tellerId);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @LoggedInvocation
    public String updateTeller() {
        try {
            this.overrideMessage = "";
            tellersDAO.update(this.teller);
        } catch (OptimisticLockException e) {
            this.overrideMessage = "value was overriden";
            try {
                Teller newTeller = tellersDAO.findOne(this.teller.getId());
                newTeller.setDepartment(teller.getDepartment());
                tellersDAO.update(newTeller);
            } catch (OptimisticLockException ex) {
                return "/tellerDetails.xhtml?faces-redirect=true&tellerId=" + this.teller.getId() + "&error=optimistic-lock-exception";
            }
        }
//        return "tellers.xhtml?bankId=" + this.teller.getBank().getId() + "&faces-redirect=true";

        return "/tellerDetails.xhtml?faces-redirect=true&tellerId=" + this.teller.getId() + "&overrideMessage=" + overrideMessage;
    }
}
