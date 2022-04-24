package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Bank;
import vu.lt.entities.Client;
import vu.lt.entities.Teller;
import vu.lt.persistence.BanksDAO;
import vu.lt.persistence.ClientsDAO;
import vu.lt.persistence.TellersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
public class Clients {

    @Inject
    private ClientsDAO clientsDAO;

    @Inject
    private TellersDAO tellersDAO;

    @Getter @Setter
    private Client clientToCreate = new Client();

    @Getter @Setter
    private String clientIdToSet;

    @Getter @Setter
    private Teller teller;

    @Getter
    private List<Client> allClients;

    @PostConstruct
    public void init(){
        setCurrentTeller();
        loadAllClients();
    }

    @Transactional
    public String createClient(){
        clientToCreate.addTeller(this.teller);
        this.clientsDAO.persist(clientToCreate);
        return "tellerDetails.xhtml?tellerId=" + this.teller.getId() + "&faces-redirect=true";
    }

    @Transactional
    public String addClientToTeller(){
        Client client = clientsDAO.findOne(Integer.parseInt(clientIdToSet));
        client.addTeller(this.teller);
        clientsDAO.update(client);
        return "tellerDetails.xhtml?tellerId=" + this.teller.getId() + "&faces-redirect=true";
    }

    private void setCurrentTeller(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer tellerId = Integer.parseInt(requestParameters.get("tellerId"));
        this.teller = tellersDAO.findOne(tellerId);
    }

    private void loadAllClients(){
        this.allClients = clientsDAO.loadAll();
    }
}
