package com.tysj.domain.util;

/**
 * @Classname ResultInformationEnum
 * @Description TODO
 * @Date 2018/11/9 11:04
 * @Created by xzcawl
 */
public enum ResultInformationEnum {


    /** 公共返回 */

    SUCCESS("0000", "成功"),
    ERROR("0001","失败"),
    UNKNOWN_ERROR("0002","未知异常"),
    EXECUTE_RROR("00003","执行异常");


    private String errorCode;
    private String errorMsg;

    ResultInformationEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorMsg(String extMsg) {
        return errorMsg + ":" + extMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
