package com.example.demo.exception;

/**
 * <p>Title: </p>
 *
 * @author dyh
 * @date 2018/6/9.
 * <p>Description: </p>
 */
public class UserBizException extends RuntimeException {
    /**
     * 异常码
     */
    protected int code;
    /**
     * 异常信息
     */
    protected String message;

    private static final long serialVersionUID = 3160241586346324994L;

    public UserBizException() {
    }

    public UserBizException(Throwable cause) {
        super(cause);
    }

    public UserBizException(String message) {
        super(message);
    }

    public UserBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserBizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public UserBizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

   /* public UserBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }*/

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BizException [message=" + message + ", code=" + code + "]";
    }
}
