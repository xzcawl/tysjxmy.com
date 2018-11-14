package com.tysj.domain.util;

import java.io.Serializable;

/**
 * @Classname GenericResult
 * @Description TODO 通用返回结果类
 * @Date 2018/11/9 11:14
 * @Created by xzcawl
 */
public class GeneralResult<T> extends Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private T value;

    public GeneralResult() {
    }

    public GeneralResult(ResultInformationEnum information) {
        super(information);
    }

    public GeneralResult(String code, String message) {
        super(code, message);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
