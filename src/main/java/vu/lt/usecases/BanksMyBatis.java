package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.BankMapper;
import vu.lt.mybatis.dao.TellerMapper;
import vu.lt.mybatis.model.Bank;
import vu.lt.mybatis.model.Teller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
public class BanksMyBatis {
    @Inject
    private BankMapper bankMapper;

    @Inject
    private TellerMapper tellerMapper;

    @Getter
    private List<Bank> allBanks;

    @Getter @Setter
    private Bank bankToCreate = new Bank();

    @Getter @Setter
    private List<Teller> tellersWithNoDepartment = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadAllBanks();
        this.loadTellersWithNoDepartment();
    }

    private void loadAllBanks() {
        this.allBanks = bankMapper.selectAll();
    }

    private void loadTellersWithNoDepartment() {
        this.tellersWithNoDepartment = tellerMapper.selectTellersWithNoDepartment();
    }

    @Transactional
    public String createBank() {
        bankMapper.insert(bankToCreate);
        return "/myBatis/banks?faces-redirect=true";
    }
}
