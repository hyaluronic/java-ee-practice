package vu.lt.mybatis.model;

public class Bank {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BANK.ID
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BANK.NAME
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BANK.ID
     *
     * @return the value of PUBLIC.BANK.ID
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BANK.ID
     *
     * @param id the value for PUBLIC.BANK.ID
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BANK.NAME
     *
     * @return the value of PUBLIC.BANK.NAME
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BANK.NAME
     *
     * @param name the value for PUBLIC.BANK.NAME
     *
     * @mbg.generated Sun May 01 15:25:22 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}