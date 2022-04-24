package vu.lt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Teller;

@Mapper
public interface TellerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TELLER
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TELLER
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    int insert(Teller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TELLER
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    Teller selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TELLER
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    List<Teller> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TELLER
     *
     * @mbg.generated Mon Apr 18 14:51:50 EEST 2022
     */
    int updateByPrimaryKey(Teller record);
}