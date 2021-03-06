package vu.lt.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CLIENT.ID
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CLIENT.NAME
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    private String name;

    private List<Teller> tellers = new ArrayList<>();

    public List<Teller> getTellers() {
        return tellers;
    }

    public void setTellers(List<Teller> tellers) {
        this.tellers = tellers;
    }

    public void addTeller(Teller teller) {
        if (teller != null){
            tellers.add(teller);
        }
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CLIENT.ID
     *
     * @return the value of PUBLIC.CLIENT.ID
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CLIENT.ID
     *
     * @param id the value for PUBLIC.CLIENT.ID
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CLIENT.NAME
     *
     * @return the value of PUBLIC.CLIENT.NAME
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CLIENT.NAME
     *
     * @param name the value for PUBLIC.CLIENT.NAME
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}