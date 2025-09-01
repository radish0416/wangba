package com.cybercafe.common;

/**
 * 统一返回包装。
 * @param <T> 载荷类型
 */
public class ApiResponse<T> {
    /** 0=成功 其它=错误码 */
    private Integer code;
    /** 提示信息 */
    private String message;
    /** 载荷数据 */
    private T data;

    private ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回。
     * @param data 数据
     * @return 包装
     * @param <T> 泛型
     */
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(0, "OK", data);
    }

    /**
     * 失败返回。
     * @param code 错误码
     * @param message 提示信息
     * @return 包装
     * @param <T> 泛型
     */
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public Integer getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}