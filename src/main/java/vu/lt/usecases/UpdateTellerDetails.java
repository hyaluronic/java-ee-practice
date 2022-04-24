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
@Getter @Setter
public class UpdateTellerDetails implements Serializable {

    private Teller teller;

    @Inject
    private TellersDAO tellersDAO;

    @PostConstruct
    private void init() {
        System.out.println("updateTellerClients INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer tellerId = Integer.parseInt(requestParameters.get("tellerId"));
        this.teller = tellersDAO.findOne(tellerId);
    }

    @Transactional
    @LoggedInvocation
    public String updateTeller() {
        try{
            tellersDAO.update(this.teller);
        } catch (OptimisticLockException e) {
            return "/tellerDetails.xhtml?faces-redirect=true&tellerId=" + this.teller.getId() + "&error=optimistic-lock-exception";
        }
        return "tellers.xhtml?bankId=" + this.teller.getBank().getId() + "&faces-redirect=true";
    }
}
