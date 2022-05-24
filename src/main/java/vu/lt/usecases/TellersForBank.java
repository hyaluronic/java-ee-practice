package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Bank;
import vu.lt.entities.Teller;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.BanksDAO;
import vu.lt.services.teller.TellerServiceImpl;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class TellersForBank implements Serializable {

    @Inject
    private BanksDAO banksDAO;

    @Inject
    private TellerServiceImpl tellerServiceImpl;

    @Getter @Setter
    private Bank bank;

    @Getter @Setter
    private Teller tellerToCreate = new Teller();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer bankId = Integer.parseInt(requestParameters.get("bankId"));
        this.bank = banksDAO.findOne(bankId);
    }

    @Transactional
    @LoggedInvocation
    public String createTeller() {
        tellerServiceImpl.createTeller(this.bank, tellerToCreate);
        return "tellers?faces-redirect=true&bankId=" + this.bank.getId();
    }
}
