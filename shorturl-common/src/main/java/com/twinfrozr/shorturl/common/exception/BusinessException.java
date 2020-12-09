package com.twinfrozr.shorturl.common.exception;

/**
 * BusinessException
 *
 * @author marvin
 */
public class BusinessException extends RuntimeException {

    private final String code;

    private final String message;

    public BusinessException(String defaultMessage)
    {
        this(null, defaultMessage);
    }

    public BusinessException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BusinessException (LocalError localError) {
        this(localError.getCode(), localError.getMessage());
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LocalError getLocalError() {
        final BusinessException businessException = this;
        return new LocalError() {
            public String getMessage() {
                return businessException.getMessage();
            }

            @Override
            public String getCode() {
                return businessException.getCode();
            }
        };

    }
}
