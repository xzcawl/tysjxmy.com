package com.tysj.domain.util;

import java.io.Serializable;

/**
 * @Classname BasicResult
 * @Description TODO 基础返回结果类
 * @Date 2018/11/9 11:09
 * @Created by xzcawl
 */
public class BasicResult extends Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public BasicResult(ResultInformationEnum information) {
        super(information);
    }

    public BasicResult(String code, String message) {
        super(code, message);
    }

    public BasicResult() {
    }
}
