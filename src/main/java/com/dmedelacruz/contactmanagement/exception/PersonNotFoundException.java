package com.dmedelacruz.contactmanagement.exception;

import lombok.Data;

@Data
public class PersonNotFoundException extends RuntimeException {

    private final ErrorMessage errorMessage;

}
