package com.digitalinnovation.salas.de.reuniao.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
public class MyErrorDetails {

    private Date timestamp;
    private String messageError;
    private String datails;

    public MyErrorDetails(Date timestamp, String messageError, String datails) {
        super();
        this.timestamp = timestamp;
        this.messageError = messageError;
        this.datails = datails;
    }

}
