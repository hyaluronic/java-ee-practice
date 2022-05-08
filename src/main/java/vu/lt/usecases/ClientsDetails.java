package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Account;
import vu.lt.entities.Client;
import vu.lt.persistence.AccountDAO;
import vu.lt.persistence.ClientsDAO;
import vu.lt.services.account.AccountNumberValidator;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class ClientsDetails {

    @Inject
    private ClientsDAO clientsDAO;

    @Inject
    private AccountDAO accountDAO;

    @Inject
    private AccountNumberValidator accountNumberValidator;

    @Getter @Setter
    private Account accountToCreate = new Account();

    @Getter @Setter
    private Client client;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer clientId = Integer.parseInt(requestParameters.get("clientId"));
        this.client = clientsDAO.findOne(clientId);
    }

    @Transactional
    public String createAccount(){
        if (client.getAccount() != null){
            return "/clients.xhtml?faces-redirect=true&clientId=" + this.client.getId() + "&error=client-account-exists-exception";
        }

        try {
            accountNumberValidator.validate(accountToCreate.getNumber());
        } catch (IllegalArgumentException e){
            return "/clients.xhtml?faces-redirect=true&clientId=" + this.client.getId() + "&error=illegal-account-number-exception";
        }

        accountToCreate.setClient(client);
        this.accountDAO.persist(accountToCreate);
        return "clients.xhtml?clientId=" + this.client.getId() + "&faces-redirect=true";
    }
}
