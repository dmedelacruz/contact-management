package com.dmedelacruz.contactmanagement.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
public class ErrorMessage {

    private Integer code;
    private String status;
    @JsonProperty("time_stamp")
    private final Date timeStamp;
    private final String message;

}
