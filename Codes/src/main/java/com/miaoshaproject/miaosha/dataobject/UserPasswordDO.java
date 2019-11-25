package com.miaoshaproject.miaosha.dataobject;

import org.springframework.stereotype.Repository;

@Repository
public class UserPasswordDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.id
     *
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.encrpt_password
     *
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    private String encrptPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_password.user_id
     *
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.id
     *
     * @return the value of user_password.id
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.id
     *
     * @param id the value for user_password.id
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.encrpt_password
     *
     * @return the value of user_password.encrpt_password
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    public String getEncrptPassword() {
        return encrptPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.encrpt_password
     *
     * @param encrptPassword the value for user_password.encrpt_password
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword == null ? null : encrptPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_password.user_id
     *
     * @return the value of user_password.user_id
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_password.user_id
     *
     * @param userId the value for user_password.user_id
     * @mbggenerated Tue Mar 19 14:44:24 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}