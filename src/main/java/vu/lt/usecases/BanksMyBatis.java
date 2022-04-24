package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.BankMapper;
import vu.lt.mybatis.model.Bank;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class BanksMyBatis {
    @Inject
    private BankMapper bankMapper;

    @Getter
    private List<Bank> allBanks;

    @Getter @Setter
    private Bank bankToCreate = new Bank();

    @PostConstruct
    public void init() {
        this.loadAllBanks();
    }

    private void loadAllBanks() {
        this.allBanks = bankMapper.selectAll();
    }

    @Transactional
    public String createBank() {
        bankMapper.insert(bankToCreate);
        return "/myBatis/banks?faces-redirect=true";
    }
}
