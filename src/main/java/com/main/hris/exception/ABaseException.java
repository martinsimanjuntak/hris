package com.main.hris.exception;

import java.text.MessageFormat;

public abstract class ABaseException extends RuntimeException {
    private static final long serialVersionUID = -1423699861420102978L;

    public ABaseException(String message, Object... arguments) {
        super(getMessage(message, arguments));
    }

    public ABaseException(String message, Throwable cause, Object... arguments) {
        super(getMessage(message, arguments), cause);
    }

    protected static String getMessage(String message, Object... arguments) {
        if (arguments != null && arguments.length > 0)
            message = MessageFormat.format(message, arguments);
        return message;
    }
}
