package com.buer.dto;

/**
 * @Description:
 * @ClassName:ResultInfo
 * @Author:yuhaining
 * @Date:2019/9/28 0028
 */
public class ResultInfo<T> {
    String code = "011";
    String message;
    T date;

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

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
