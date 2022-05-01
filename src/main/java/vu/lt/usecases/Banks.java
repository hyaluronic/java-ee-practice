package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Bank;
import vu.lt.persistence.BanksDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model //@Names ir @RequestScoped, gali buti iterptas i JSF failus
public class Banks {

    @Inject
    private BanksDAO banksDAO;

    @Getter @Setter
    private Bank bankToCreate = new Bank();

    @Getter
    private List<Bank> allBanks;

    @PostConstruct
    public void init(){
        loadAllBanks();
    }

    @Transactional
    public String createBank(){
        this.banksDAO.persist(bankToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllBanks(){
        this.allBanks = banksDAO.loadAll();
    }
}
