package ca.qc.grasset.ag420pb412B.tp03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException
    extends Exception {

    private static final long serialVersionUID = 1512248658310027450L;

    public ResourceNotFoundException(final String message_) {

        super(message_);
    }
}
