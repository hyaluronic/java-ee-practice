package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.BankMapper;
import vu.lt.mybatis.dao.ClientMapper;
import vu.lt.mybatis.dao.ClientTellerMapper;
import vu.lt.mybatis.dao.TellerMapper;
import vu.lt.mybatis.model.Bank;
import vu.lt.mybatis.model.Client;
import vu.lt.mybatis.model.ClientTeller;
import vu.lt.mybatis.model.Teller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class TellersMyBatis {
    @Inject
    private ClientMapper clientMapper;

    @Inject
    private TellerMapper tellerMapper;

    @Inject
    private ClientTellerMapper clientTellerMapper;

    @Getter
    private List<Client> allClients;

    @Getter
    private Teller teller;

    @Getter @Setter
    private Client clientToAdd = new Client();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer tellerId = requestParameters.get("tellerId") != null ? Integer.parseInt(requestParameters.get("tellerId")) : null;
        this.teller = tellerMapper.selectByPrimaryKey(tellerId);

        this.loadAllClients();
    }

    private void loadAllClients() {
        this.allClients = clientMapper.selectAll();
    }

    @Transactional
    public String addClient() {
        clientToAdd.addTeller(teller);
        clientMapper.insert(clientToAdd);
        teller.addClient(clientToAdd);
        tellerMapper.updateByPrimaryKey(teller);
        ClientTeller clientTeller = new ClientTeller();
        clientTeller.setClientsId(clientToAdd.getId());
        clientTeller.setTellersId(teller.getId());
        clientTellerMapper.insert(clientTeller);
        return "/myBatis/tellerDetails?tellerId=" + teller.getId() + "&faces-redirect=true";
    }

}
