package com.tysj.domain.util;

import java.util.List;

/**
 * @Classname DataModel
 * @Description TODO
 * @Date 2018/11/9 16:36
 * @Created by xzcawl
 */
public class DataModel<T> {

    private final int draw;
    private final int recordsTotal;
    private final int recordsFiltered;
    private final List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DataModel(int draw, int recordsTotal, int recordsFiltered, List<T> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                '}';
    }
}
