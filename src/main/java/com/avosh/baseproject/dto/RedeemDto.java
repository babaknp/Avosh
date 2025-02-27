/*******************************************************************************
 * Created by Alireza Amirkhani 2022
 ******************************************************************************/

package com.avosh.baseproject.dto;

import java.util.Date;

public class RedeemDto extends BaseDto {
    protected Long id;
    private String title;
    private String desc;
    private Long amount;
    private String code;
    private Date expireDate;
    private Date startDate;
    private Boolean multiple;
    private Integer count;
    private Date createDate;
    private UserDto userDto;

    public RedeemDto() {
    }

    public RedeemDto(Long id, String title, String desc, Long amount, String code, Date expireDate, Date startDate, Boolean multiple, Integer count, Date createDate, UserDto userDto) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.amount = amount;
        this.code = code;
        this.expireDate = expireDate;
        this.startDate = startDate;
        this.multiple = multiple;
        this.count = count;
        this.createDate = createDate;
        this.userDto = userDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
