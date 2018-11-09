package com.tysj.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname SeatDetail
 * @Description TODO 座位详情
 * @Date 2018/11/9 10:32
 * @Created by xzcawl
 */
public class SeatDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;//索引号

    private String floor;//楼层

    private String area;//区位

    private String tableNumber;//台号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "SeatDetail{" +
                "id=" + id +
                ", floor='" + floor + '\'' +
                ", area='" + area + '\'' +
                ", tableNumber='" + tableNumber + '\'' +
                '}';
    }
}
