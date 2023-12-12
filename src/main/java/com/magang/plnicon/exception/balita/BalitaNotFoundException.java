package com.magang.plnicon.exception.balita;

import com.magang.plnicon.exception.NotFoundException;

import java.io.Serial;

public class BalitaNotFoundException extends NotFoundException {

    @Serial
    private static final long serialVersionUID = 6756200070542203753L;

    private static final String DEFAULT_MESSAGE =
            "The specified Balita is not found!";

    private static final String MESSAGE_TEMPLATE =
            "No balita found with ID: ";

    public BalitaNotFoundException(String id) {
        super(MESSAGE_TEMPLATE.concat(id));
    }

    public BalitaNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
