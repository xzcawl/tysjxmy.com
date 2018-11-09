package com.tysj.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname GuestInformation
 * @Description TODO 预定座位客人信息
 * @Date 2018/11/9 10:43
 * @Created by xzcawl
 */
public class GuestInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;//索引号

    private Long tableNumber;//台号

    private String guestName;//客人姓名

    private String guestPhone;//客人电话

    private String remarks;//备注

    private String state;//状态

    private Date createTime;//创建时间

    private Date preTableTime;//预定就餐时间

    private String operator;//操作人员

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPreTableTime() {
        return preTableTime;
    }

    public void setPreTableTime(Date preTableTime) {
        this.preTableTime = preTableTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "GuestInformation{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", guestName='" + guestName + '\'' +
                ", guestPhone='" + guestPhone + '\'' +
                ", remarks='" + remarks + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                ", preTableTime=" + preTableTime +
                ", operator='" + operator + '\'' +
                '}';
    }
}








