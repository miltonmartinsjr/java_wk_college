package ca.qc.grasset.ag420pb412B.tp03.exception;

import java.util.Date;

public final class ErrorDetails {
    private final String details;

    private final String message;

    private final Date timestamp;

    public ErrorDetails(final Date timestamp_, final String message_, final String details_) {

        super();
        this.timestamp = timestamp_;
        this.message = message_;
        this.details = details_;
    }

    public String getDetails() {

        return this.details;
    }

    public String getMessage() {

        return this.message;
    }

    public Date getTimestamp() {

        return this.timestamp;
    }
}
