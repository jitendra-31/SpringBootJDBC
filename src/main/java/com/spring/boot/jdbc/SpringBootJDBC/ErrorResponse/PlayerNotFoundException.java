package com.spring.boot.jdbc.SpringBootJDBC.ErrorResponse;

import net.bytebuddy.implementation.bytecode.Throw;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(){
        super();
    }

    public PlayerNotFoundException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
    }

    public PlayerNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }

    public PlayerNotFoundException(String msg){
        super(msg);
    }

    public PlayerNotFoundException(Throwable cause){
        super(cause);
    }
}
