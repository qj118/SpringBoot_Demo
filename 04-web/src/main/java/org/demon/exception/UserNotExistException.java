package org.demon.exception;

/**
 * 自定义异常
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("User not exist!");
    }
}
