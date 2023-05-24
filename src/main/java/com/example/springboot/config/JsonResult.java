package com.example.springboot.config;

import lombok.Data;

/**
 * 统一返回格式
 * @param <T>
 */
@Data
public class JsonResult<T> {
    // 返回的code
    private static final String ERROR_CODE = "-1";

    private static final String SUCCESS_CODE = "200";

    private T data;
    private String code;
    private String msg;
    /**
     * 若没有数据返回，默认状态码为200，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = "200";
        this.msg = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static JsonResult error(String msg) {
        JsonResult result = new JsonResult<>();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = "200";
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = "200";
        this.msg = msg;
    }

    public static JsonResult success(Object data) {
        JsonResult result = new JsonResult();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static JsonResult success() {
        JsonResult result = new JsonResult();
        result.setCode(SUCCESS_CODE);
        return result;
    }
}
