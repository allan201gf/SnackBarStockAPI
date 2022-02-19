package br.com.allangf.SnackBarStockAPI.domain.exception;

import br.com.allangf.SnackBarStockAPI.rest.Errors;

public class PasswordInvalidOfException extends RuntimeException {

    public PasswordInvalidOfException(String message) {
        super(Errors.PASSWORD_IS_WRONG);
    }

}
