package com.rock.exception;

/**
 * 自定义异常
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("该用户不存在");
    }
}
