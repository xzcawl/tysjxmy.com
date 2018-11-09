package com.tysj.domain.util;

import java.io.Serializable;

/**
 * @Classname Result
 * @Description TODO 返回结果抽象类
 * @Date 2018/11/9 11:03
 * @Created by xzcawl
 */
public abstract class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    public Result() {
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(ResultInformationEnum information) {
        if(information!=null){
            code = information.getErrorCode();
            message = information.getErrorMsg();
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setInformation(ResultInformationEnum information){
        if(information!=null){
            code = information.getErrorCode();
            message = information.getErrorMsg();
        }
    }

//    public void setInfo(AppRuntimeException info){
//        if(info!=null){
//            code = info.getErrorCode();
//            if(code==null)
//                setInfo(ResultInfoEnum.UNKNOWN_ERROR);
//            message = info.getMessage();
//        }else{
//            setInfo(ResultInfoEnum.UNKNOWN_ERROR);
//        }
//    }
}
