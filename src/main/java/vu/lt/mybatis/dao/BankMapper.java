package vu.lt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Bank;

@Mapper
public interface BankMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BANK
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BANK
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    int insert(Bank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BANK
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    Bank selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BANK
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    List<Bank> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BANK
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    int updateByPrimaryKey(Bank record);
}